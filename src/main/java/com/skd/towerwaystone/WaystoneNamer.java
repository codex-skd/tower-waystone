package com.skd.towerwaystone;

import com.google.gson.JsonObject;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;

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

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            LevelChunk chunk = event.getChunk();
            for (BlockEntity be : chunk.getBlockEntities().values()) {
                Block block = be.getBlockState().getBlock();
                Identifier id = BuiltInRegistries.BLOCK.getKey(block);
                if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                    BlockPos pos = be.getBlockPos().immutable();
                    if (NAMED.contains(pos)) {
                        continue;
                    }

                    String name = NAMES[RANDOM.nextInt(NAMES.length)];
                    JsonObject json = new JsonObject();
                    json.addProperty("text", name);

                    try {
                        CompoundTag tag = be.saveWithFullMetadata(serverLevel.registryAccess());
                        if (!tag.contains("WaystoneName")) {
                            tag.putString("WaystoneName", json.toString());
                            BlockEntity newBe = BlockEntity.loadStatic(pos, be.getBlockState(), tag, serverLevel.registryAccess());
                            if (newBe != null) {
                                chunk.setBlockEntity(newBe);
                                newBe.setChanged();
                                NAMED.add(pos);
                                WaystoneTowersMod.LOGGER.debug("Named waystone at {} as '{}'", pos, name);
                            }
                        }
                    } catch (Exception e) {
                        WaystoneTowersMod.LOGGER.error("Failed to name waystone at {}: {}", pos, e.getMessage());
                    }
                }
            }
        }
    }
}