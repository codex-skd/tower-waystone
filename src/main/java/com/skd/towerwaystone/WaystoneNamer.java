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
    private static final int MAX_RETRIES = 10;

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            LevelChunk chunk = event.getChunk();
            for (BlockEntity be : chunk.getBlockEntities().values()) {
                Block block = be.getBlockState().getBlock();
                Identifier id = BuiltInRegistries.BLOCK.getKey(block);
                if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                    BlockPos pos = be.getBlockPos().immutable();
                    serverLevel.getServer().execute(() -> nameWaystone(serverLevel, pos, 0));
                }
            }
        }
    }

    private void nameWaystone(ServerLevel level, BlockPos pos, int retries) {
        if (NAMED.contains(pos)) return;
        Optional<Waystone> opt = WaystonesAPI.getWaystoneAt(level, pos);
        if (opt.isEmpty() || !(opt.get() instanceof MutableWaystone mutable)) {
            if (retries < MAX_RETRIES) {
                level.getServer().execute(() -> nameWaystone(level, pos, retries + 1));
            } else {
                WaystoneTowersMod.LOGGER.warn("Gave up naming waystone at {} after {} retries", pos, MAX_RETRIES);
                NAMED.add(pos);
            }
            return;
        }
        Waystone waystone = opt.get();
        if (waystone.hasName()) {
            NAMED.add(pos);
            return;
        }
        if (waystone.getOrigin() == WaystoneOrigin.PLAYER) {
            NAMED.add(pos);
            return;
        }
        String name = NAMES[RANDOM.nextInt(NAMES.length)];
        mutable.setName(Component.literal(name));
        NAMED.add(pos);
        WaystoneTowersMod.LOGGER.info("Named waystone at {} to '{}'", pos, name);
    }
}