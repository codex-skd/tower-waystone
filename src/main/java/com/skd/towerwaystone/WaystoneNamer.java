package com.skd.towerwaystone;

import net.blay09.mods.waystones.api.MutableWaystone;
import net.blay09.mods.waystones.api.Waystone;
import net.blay09.mods.waystones.api.WaystoneOrigin;
import net.blay09.mods.waystones.api.WaystonesAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WaystoneNamer {
    private static final String[] NAMES = {
            "Whispering Peak", "Stormwatch", "Elder Spire", "Dawn's Rest",
            "Moonlit Tower", "Ashen Crown", "Iron Sentinel", "Frostwatch Keep",
            "Shadowmere", "Sunspire", "Crystal Haven", "Ember Peak",
            "Wilder's Perch", "Ancient Cradle", "Raven's Roost", "Thorned Beacon"
    };
    private static final Random RANDOM = new Random();
    private static final Set<BlockPos> NAMED = ConcurrentHashMap.newKeySet();
    private static final Map<BlockPos, PendingWaystone> PENDING = new ConcurrentHashMap<>();
    private static final int MAX_RETRIES = 10;

    private record PendingWaystone(ServerLevel level, int retriesLeft) {
    }

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            LevelChunk chunk = event.getChunk();
            for (BlockEntity be : chunk.getBlockEntities().values()) {
                Block block = be.getBlockState().getBlock();
                Identifier id = BuiltInRegistries.BLOCK.getKey(block);
                if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                    BlockPos pos = be.getBlockPos().immutable();
                    PENDING.put(pos, new PendingWaystone(serverLevel, MAX_RETRIES));
                }
            }
        }
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        if (PENDING.isEmpty()) return;
        Iterator<Map.Entry<BlockPos, PendingWaystone>> it = PENDING.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<BlockPos, PendingWaystone> entry = it.next();
            nameWaystone(entry, it);
        }
    }

    private void nameWaystone(Map.Entry<BlockPos, PendingWaystone> entry, Iterator<Map.Entry<BlockPos, PendingWaystone>> it) {
        BlockPos pos = entry.getKey();
        PendingWaystone pending = entry.getValue();
        ServerLevel level = pending.level();
        if (NAMED.contains(pos)) {
            it.remove();
            return;
        }
        Optional<Waystone> opt = WaystonesAPI.getWaystoneAt(level, pos);
        if (opt.isEmpty() || !(opt.get() instanceof MutableWaystone mutable)) {
            if (pending.retriesLeft() > 0) {
                entry.setValue(new PendingWaystone(level, pending.retriesLeft() - 1));
            } else {
                TowerWaystone.LOGGER.warn("Gave up naming waystone at {} after {} retries", pos, MAX_RETRIES);
                NAMED.add(pos);
                it.remove();
            }
            return;
        }
        Waystone waystone = opt.get();
        if (waystone.hasName()) {
            NAMED.add(pos);
            it.remove();
            return;
        }
        if (waystone.getOrigin() == WaystoneOrigin.PLAYER) {
            NAMED.add(pos);
            it.remove();
            return;
        }
        String name = NAMES[RANDOM.nextInt(NAMES.length)];
        mutable.setName(Component.literal(name));
        NAMED.add(pos);
        it.remove();
        TowerWaystone.LOGGER.info("Named waystone at {} to '{}'", pos, name);
    }
}