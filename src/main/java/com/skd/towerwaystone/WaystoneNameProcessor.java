package com.skd.towerwaystone;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class WaystoneNameProcessor extends StructureProcessor {

    public static final MapCodec<WaystoneNameProcessor> CODEC = MapCodec.unit(new WaystoneNameProcessor());

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(
            LevelReader level, BlockPos offset, BlockPos pos,
            StructureTemplate.StructureBlockInfo blockInfo,
            StructureTemplate.StructureBlockInfo relativeBlockInfo,
            StructurePlaceSettings settings) {
        return blockInfo;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return WaystoneTowersMod.WAYSTONE_NAME_PROCESSOR.get();
    }
}
