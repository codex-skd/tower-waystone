package com.skd.towerwaystone;

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
                    WaystoneTowersMod.LOGGER.info("Detected nameless waystone at {} in chunk ({}), scheduling name...",
                            pos, chunk.getPos());

                    serverLevel.getServer().execute(() -> {
                        if (NAMED.contains(pos.immutable())) return;
                        LevelChunk currentChunk = serverLevel.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
                        if (currentChunk == null) return;
                        BlockEntity currentBe = currentChunk.getBlockEntity(pos);
                        if (currentBe == null) {
                            WaystoneTowersMod.LOGGER.warn("Waystone BE vanished at {}", pos);
                            return;
                        }

                        String name = NAMES[RANDOM.nextInt(NAMES.length)];

                        try {
                            CompoundTag tag = currentBe.saveWithFullMetadata(serverLevel.registryAccess());
                            // Log all tag keys to see what the waystone has
                            WaystoneTowersMod.LOGGER.info("Waystone tag keys: size={}", tag.keySet().size());

                            // Try setting waystone_name as a CompoundTag (Component format)
                            CompoundTag nameTag = new CompoundTag();
                            nameTag.putString("text", name);
                            tag.put("waystone_name", nameTag);

                            // Also try CustomName as fallback (vanilla component)
                            CompoundTag customName = new CompoundTag();
                            customName.putString("text", name);
                            tag.put("CustomName", customName);

                            BlockEntity newBe = BlockEntity.loadStatic(pos, currentBe.getBlockState(), tag, serverLevel.registryAccess());
                            if (newBe != null) {
                                currentChunk.setBlockEntity(newBe);
                                newBe.setChanged();
                                NAMED.add(pos.immutable());
                                WaystoneTowersMod.LOGGER.info("Applied name '{}' at {}", name, pos);

                                // Log tag keys after
                                CompoundTag afterTag = newBe.saveWithFullMetadata(serverLevel.registryAccess());
                                WaystoneTowersMod.LOGGER.info("Waystone tag keys after: size={}", afterTag.keySet().size());
                            }
                        } catch (Exception e) {
                            WaystoneTowersMod.LOGGER.error("Failed to name waystone at {}: {}", pos, e.getMessage());
                        }
                    });
                }
            }
        }
    }
}