package com.skd.towerwaystone.world.features;

import com.mojang.serialization.Codec;
import com.skd.towerwaystone.world.features.configurations.StructureFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StructureFeature extends Feature<StructureFeatureConfiguration> {

    public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, "tower_waystone");
    public static final DeferredHolder<Feature<?>, StructureFeature> STRUCTURE_FEATURE = REGISTRY.register("structure_feature",
            () -> new StructureFeature(StructureFeatureConfiguration.CODEC));

    public StructureFeature(Codec<StructureFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
        RandomSource random = context.random();
        WorldGenLevel worldGenLevel = context.level();
        StructureFeatureConfiguration config = context.config();

        Rotation rotation = config.randomRotation() ? Rotation.getRandom(random) : Rotation.NONE;
        Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(2)] : Mirror.NONE;

        StructureTemplateManager structureManager = worldGenLevel.getLevel().getServer().getStructureManager();
        StructureTemplate template = structureManager.getOrCreate(config.structure());

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRotation(rotation)
                .setMirror(mirror)
                .setRandom(random)
                .setIgnoreEntities(false)
                .addProcessor(new BlockIgnoreProcessor(
                        config.ignoredBlocks().stream()
                                .map(holder -> holder.value())
                                .toList()
                ));

        BlockPos offsetPos = context.origin().offset(
                StructureTemplate.calculateRelativePosition(settings, new BlockPos(config.offset())));

        template.placeInWorld(worldGenLevel, offsetPos, offsetPos, settings, random, 2);

        return true;
    }
}
