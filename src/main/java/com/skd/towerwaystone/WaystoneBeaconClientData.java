package com.skd.towerwaystone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;

@OnlyIn(Dist.CLIENT)
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

    public static Set<BlockPos> getWaystonePositions() {
        return WAYSTONE_POSITIONS;
    }
}