package com.skd.towerwaystone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;

public class WaystoneBeaconClientData {
    private static final Set<BlockPos> WAYSTONE_POSITIONS = ConcurrentHashMap.newKeySet();

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        if (!event.getLevel().isClientSide()) return;
        LevelChunk chunk = event.getChunk();
        for (BlockEntity be : chunk.getBlockEntities().values()) {
            Block block = be.getBlockState().getBlock();
            net.minecraft.resources.Identifier id = BuiltInRegistries.BLOCK.getKey(block);
            if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                WAYSTONE_POSITIONS.add(be.getBlockPos().immutable());
            }
        }
    }

    @SubscribeEvent
    public void onChunkUnload(ChunkEvent.Unload event) {
        if (!event.getLevel().isClientSide()) return;
        LevelChunk chunk = event.getChunk();
        for (BlockEntity be : chunk.getBlockEntities().values()) {
            Block block = be.getBlockState().getBlock();
            net.minecraft.resources.Identifier id = BuiltInRegistries.BLOCK.getKey(block);
            if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                WAYSTONE_POSITIONS.remove(be.getBlockPos().immutable());
            }
        }
    }

    private static int tickCounter = 0;

    @SubscribeEvent
    public void onClientTick(ClientTickEvent event) {
        // Re-scanning the whole render-distance square is cheap enough once a second,
        // but not worth doing all 20 times a second - a waystone placed/broken in an
        // already-loaded chunk only needs to appear/disappear promptly, not instantly.
        if (tickCounter++ % 20 != 0) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;
        int renderDistance = mc.options.getEffectiveRenderDistance();
        int playerX = mc.player.getBlockX();
        int playerZ = mc.player.getBlockZ();
        int playerChunkX = Math.floorDiv(playerX, 16);
        int playerChunkZ = Math.floorDiv(playerZ, 16);
        Set<BlockPos> newSet = ConcurrentHashMap.newKeySet();
        for (int dx = -renderDistance; dx <= renderDistance; dx++) {
            for (int dz = -renderDistance; dz <= renderDistance; dz++) {
                int chunkX = playerChunkX + dx;
                int chunkZ = playerChunkZ + dz;
                if (mc.level.getChunkSource().hasChunk(chunkX, chunkZ)) {
                    LevelChunk chunk = mc.level.getChunkSource().getChunk(chunkX, chunkZ, true);
                    if (chunk != null) {
                        for (BlockEntity be : chunk.getBlockEntities().values()) {
                            Block block = be.getBlockState().getBlock();
                            net.minecraft.resources.Identifier id = BuiltInRegistries.BLOCK.getKey(block);
                            if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                                newSet.add(be.getBlockPos().immutable());
                            }
                        }
                    }
                }
            }
        }
        WAYSTONE_POSITIONS.clear();
        WAYSTONE_POSITIONS.addAll(newSet);
    }

    public static Set<BlockPos> getWaystonePositions() {
        return WAYSTONE_POSITIONS;
    }
}