package com.skd.towerwaystone;

import com.google.gson.JsonObject;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class WaystoneNameProcessor extends StructureProcessor {

    public static final MapCodec<WaystoneNameProcessor> CODEC = MapCodec.unit(WaystoneNameProcessor::new);

    private static final String[] NAMES = {
            "Whispering Peak", "Stormwatch", "Elder Spire", "Dawn's Rest",
            "Moonlit Tower", "Ashen Crown", "Iron Sentinel", "Frostwatch Keep",
            "Shadowmere", "Sunspire", "Crystal Haven", "Ember Peak",
            "Wilder's Perch", "Ancient Cradle", "Raven's Roost", "Thorned Beacon"
    };

    @Override
    public StructureTemplate.StructureBlockInfo process(
            LevelReader level, BlockPos offset, BlockPos pos,
            StructureTemplate.StructureBlockInfo blockInfo,
            StructureTemplate.StructureBlockInfo relativeBlockInfo,
            StructurePlaceSettings settings,
            StructureTemplate template) {
        return doProcess(level, offset, pos, blockInfo, relativeBlockInfo, settings);
    }

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(
            LevelReader level, BlockPos offset, BlockPos pos,
            StructureTemplate.StructureBlockInfo blockInfo,
            StructureTemplate.StructureBlockInfo relativeBlockInfo,
            StructurePlaceSettings settings) {
        return doProcess(level, offset, pos, blockInfo, relativeBlockInfo, settings);
    }

    private StructureTemplate.StructureBlockInfo doProcess(
            LevelReader level, BlockPos offset, BlockPos pos,
            StructureTemplate.StructureBlockInfo blockInfo,
            StructureTemplate.StructureBlockInfo relativeBlockInfo,
            StructurePlaceSettings settings) {

        Block block = blockInfo.state().getBlock();
        Identifier blockId = BuiltInRegistries.BLOCK.getKey(block);

        if ("waystones".equals(blockId.getNamespace()) && blockId.getPath().contains("waystone")) {
            CompoundTag nbt = blockInfo.nbt();
            if (nbt == null) {
                return blockInfo;
            }
            nbt = nbt.copy();
            if (!nbt.contains("WaystoneName")) {
                String name = NAMES[RandomSource.create().nextInt(NAMES.length)];
                JsonObject json = new JsonObject();
                json.addProperty("text", name);
                nbt.putString("WaystoneName", json.toString());
            }
            return new StructureTemplate.StructureBlockInfo(blockInfo.pos(), blockInfo.state(), nbt);
        }

        return blockInfo;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return WaystoneTowersMod.WAYSTONE_NAME_PROCESSOR.get();
    }
}
