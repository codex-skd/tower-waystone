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

public class WaystoneNamer {
    private static final String[] NAMES = {
            "Whispering Peak", "Stormwatch", "Elder Spire", "Dawn's Rest",
            "Moonlit Tower", "Ashen Crown", "Iron Sentinel", "Frostwatch Keep",
            "Shadowmere", "Sunspire", "Crystal Haven", "Ember Peak",
            "Wilder's Perch", "Ancient Cradle", "Raven's Roost", "Thorned Beacon"
    };
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            LevelChunk chunk = event.getChunk();
            for (BlockEntity be : chunk.getBlockEntities().values()) {
                Block block = be.getBlockState().getBlock();
                Identifier id = BuiltInRegistries.BLOCK.getKey(block);
                if ("waystones".equals(id.getNamespace()) && id.getPath().contains("waystone")) {
                    CompoundTag tag = be.saveWithFullMetadata(serverLevel.registryAccess());
                    if (!tag.contains("waystone_name")) {
                        String name = NAMES[RANDOM.nextInt(NAMES.length)];
                        CompoundTag display = new CompoundTag();
                        display.putString("text", name);
                        tag.put("waystone_name", display);
                        BlockPos pos = be.getBlockPos();
                        BlockEntity newBe = BlockEntity.loadStatic(pos, be.getBlockState(), tag, serverLevel.registryAccess());
                        if (newBe != null) {
                            chunk.setBlockEntity(newBe);
                            newBe.setChanged();
                        }
                    }
                }
            }
        }
    }
}