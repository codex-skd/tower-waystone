package com.skd.towerwaystone;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicStructureRegistry {

    private static int saltCounter = 0;

    public static void onRegister(RegisterEvent event) {
        List<CustomDimensionConfig.DimensionEntry> entries = CustomDimensionConfig.getEntries();
        if (entries.isEmpty()) return;

        Identifier registryKey = event.getRegistryKey().identifier();

        if (registryKey.equals(Registries.PROCESSOR_LIST.identifier())) {
            registerProcessors(event, entries);
        } else if (registryKey.equals(Registries.TEMPLATE_POOL.identifier())) {
            registerPools(event, entries);
        } else if (registryKey.equals(Registries.STRUCTURE.identifier())) {
            registerStructures(event, entries);
        } else if (registryKey.equals(Registries.STRUCTURE_SET.identifier())) {
            registerStructureSets(event, entries);
        }
    }

    private static void registerProcessors(RegisterEvent event, List<CustomDimensionConfig.DimensionEntry> entries) {
        for (CustomDimensionConfig.DimensionEntry entry : entries) {
            Identifier id = processorId(entry);
            event.register(Registries.PROCESSOR_LIST, id, () -> buildProcessor(entry));
            TowerWaystone.LOGGER.info("Registered processor list '{}' for dimension '{}'", id, entry.getDimension());
        }
    }

    private static void registerPools(RegisterEvent event, List<CustomDimensionConfig.DimensionEntry> entries) {
        Registry<StructureProcessorList> procRegistry = event.getRegistry(Registries.PROCESSOR_LIST);
        Registry<StructureTemplatePool> poolRegistry = event.getRegistry(Registries.TEMPLATE_POOL);

        for (CustomDimensionConfig.DimensionEntry entry : entries) {
            Identifier id = poolId(entry);
            Identifier procId = processorId(entry);
            Identifier fallbackId = Identifier.parse("minecraft:empty");

            event.register(Registries.TEMPLATE_POOL, id, () -> {
                var procHolder = procRegistry.get(procId).orElseThrow();
                var fallbackHolder = poolRegistry.get(fallbackId).orElseThrow();

                return new StructureTemplatePool(
                    fallbackHolder,
                    List.of(Pair.of(StructurePoolElement.single("tower_waystone:waystone_tower", procHolder), 1)),
                    StructureTemplatePool.Projection.RIGID
                );
            });
            TowerWaystone.LOGGER.info("Registered template pool '{}' for dimension '{}'", id, entry.getDimension());
        }
    }

    private static void registerStructures(RegisterEvent event, List<CustomDimensionConfig.DimensionEntry> entries) {
        Registry<StructureTemplatePool> poolRegistry = event.getRegistry(Registries.TEMPLATE_POOL);

        for (CustomDimensionConfig.DimensionEntry entry : entries) {
            Identifier id = structureId(entry);
            Identifier poolIdLocal = poolId(entry);

            event.register(Registries.STRUCTURE, id, () -> {
                var poolHolder = poolRegistry.get(poolIdLocal).orElseThrow();

                Registry<Biome> biomeReg = event.getRegistry(Registries.BIOME);
                List<net.minecraft.core.Holder<Biome>> biomeHolders = new ArrayList<>();
                for (String biomeId : entry.getBiomes()) {
                    Identifier biomeLoc = Identifier.parse(biomeId);
                    biomeReg.get(biomeLoc).ifPresent(biomeHolders::add);
                }

                var biomes = net.minecraft.core.HolderSet.direct(biomeHolders);

                Structure.StructureSettings settings = new Structure.StructureSettings(
                    biomes,
                    Map.of(),
                    GenerationStep.Decoration.SURFACE_STRUCTURES,
                    TerrainAdjustment.NONE
                );

                return new JigsawStructure(
                    settings,
                    poolHolder,
                    1,
                    UniformHeight.of(VerticalAnchor.absolute(20), VerticalAnchor.absolute(60)),
                    false
                );
            });
            TowerWaystone.LOGGER.info("Registered structure '{}' for dimension '{}'", id, entry.getDimension());
        }
    }

    private static void registerStructureSets(RegisterEvent event, List<CustomDimensionConfig.DimensionEntry> entries) {
        Registry<Structure> structRegistry = event.getRegistry(Registries.STRUCTURE);

        for (CustomDimensionConfig.DimensionEntry entry : entries) {
            Identifier id = structureSetId(entry);
            Identifier structId = structureId(entry);

            event.register(Registries.STRUCTURE_SET, id, () -> {
                var structHolder = structRegistry.get(structId).orElseThrow();

                saltCounter++;
                RandomSpreadStructurePlacement placement = new RandomSpreadStructurePlacement(
                    64, 32, RandomSpreadType.LINEAR, saltCounter + 900000
                );

                return new StructureSet(structHolder, placement);
            });
            TowerWaystone.LOGGER.info("Registered structure set '{}' for dimension '{}'", id, entry.getDimension());
        }
    }

    private static StructureProcessorList buildProcessor(CustomDimensionConfig.DimensionEntry entry) {
        Block mainBlock = BuiltInRegistries.BLOCK.getValue(Identifier.parse(entry.getBlock()));
        Block lightBlock = BuiltInRegistries.BLOCK.getValue(Identifier.parse(entry.getLightBlock()));
        Block accentBlock = BuiltInRegistries.BLOCK.getValue(Identifier.parse(entry.getAccentBlock()));
        Block groundBlock = BuiltInRegistries.BLOCK.getValue(Identifier.parse(entry.getGroundBlock()));

        Block mainSlab = findSlab(mainBlock);
        Block mainStairs = findStairs(mainBlock);
        Block mainWall = findWall(mainBlock);

        List<ProcessorRule> rules = new ArrayList<>();
        addRule(rules, Blocks.ANDESITE, mainBlock.defaultBlockState());
        addRule(rules, Blocks.POLISHED_ANDESITE, mainBlock.defaultBlockState());
        if (mainSlab != null) addRule(rules, Blocks.POLISHED_ANDESITE_SLAB, mainSlab.defaultBlockState());
        if (mainStairs != null) addRule(rules, Blocks.POLISHED_ANDESITE_STAIRS, mainStairs.defaultBlockState());
        if (mainWall != null) addRule(rules, Blocks.ANDESITE_WALL, mainWall.defaultBlockState());
        addRule(rules, Blocks.SEA_LANTERN, lightBlock.defaultBlockState());
        addRule(rules, Blocks.DARK_PRISMARINE, accentBlock.defaultBlockState());
        addRule(rules, Blocks.DIRT, groundBlock.defaultBlockState());
        addRule(rules, Blocks.GRASS_BLOCK, groundBlock.defaultBlockState());

        return new StructureProcessorList(List.of(new RuleProcessor(rules)));
    }

    private static void addRule(List<ProcessorRule> rules, Block input, net.minecraft.world.level.block.state.BlockState output) {
        rules.add(new ProcessorRule(new BlockMatchTest(input), AlwaysTrueTest.INSTANCE, output));
    }

    private static Block findSlab(Block block) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        Identifier slabId = Identifier.fromNamespaceAndPath(id.getNamespace(), id.getPath() + "_slab");
        if (BuiltInRegistries.BLOCK.containsKey(slabId)) {
            return BuiltInRegistries.BLOCK.getValue(slabId);
        }
        return null;
    }

    private static Block findStairs(Block block) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        Identifier stairsId = Identifier.fromNamespaceAndPath(id.getNamespace(), id.getPath() + "_stairs");
        if (BuiltInRegistries.BLOCK.containsKey(stairsId)) {
            return BuiltInRegistries.BLOCK.getValue(stairsId);
        }
        return null;
    }

    private static Block findWall(Block block) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        Identifier wallId = Identifier.fromNamespaceAndPath(id.getNamespace(), id.getPath() + "_wall");
        if (BuiltInRegistries.BLOCK.containsKey(wallId)) {
            return BuiltInRegistries.BLOCK.getValue(wallId);
        }
        return null;
    }

    private static Identifier processorId(CustomDimensionConfig.DimensionEntry entry) {
        return Identifier.parse("tower_waystone:processor/custom_" + entry.getDimension().replace(':', '_'));
    }

    private static Identifier poolId(CustomDimensionConfig.DimensionEntry entry) {
        return Identifier.parse("tower_waystone:custom_" + entry.getDimension().replace(':', '_') + "_pool");
    }

    private static Identifier structureId(CustomDimensionConfig.DimensionEntry entry) {
        return Identifier.parse("tower_waystone:custom_" + entry.getDimension().replace(':', '_'));
    }

    private static Identifier structureSetId(CustomDimensionConfig.DimensionEntry entry) {
        return Identifier.parse("tower_waystone:custom_" + entry.getDimension().replace(':', '_') + "_set");
    }
}
