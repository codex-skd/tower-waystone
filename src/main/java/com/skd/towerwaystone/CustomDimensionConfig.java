package com.skd.towerwaystone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomDimensionConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static List<DimensionEntry> entries = new ArrayList<>();

    public static void load(Path configDir, Logger logger) {
        Path configFile = configDir.resolve("tower_waystone/custom_dimensions.json");
        Path configFolder = configFile.getParent();

        try {
            Files.createDirectories(configFolder);
        } catch (IOException e) {
            logger.error("Could not create config directory: {}", configFolder, e);
            return;
        }

        if (!Files.exists(configFile)) {
            createDefaultConfig(configFile, logger);
            return;
        }

        try (Reader reader = Files.newBufferedReader(configFile)) {
            List<DimensionEntry> raw = GSON.fromJson(reader, new TypeToken<List<DimensionEntry>>() {}.getType());
            if (raw == null) {
                logger.warn("Could not parse custom_dimensions.json, using empty config");
                return;
            }
            entries = new ArrayList<>();
            for (DimensionEntry entry : raw) {
                if (entry.dimension == null || entry.dimension.isBlank()) {
                    logger.warn("Skipping config entry with missing dimension ID");
                    continue;
                }
                if (entry.biomes == null || entry.biomes.isEmpty()) {
                    logger.warn("Skipping dimension '{}' - no biomes specified", entry.dimension);
                    continue;
                }

                if (entry.block != null && !entry.block.isBlank()) {
                    Identifier blockId = Identifier.parse(entry.block);
                    if (!BuiltInRegistries.BLOCK.containsKey(blockId)) {
                        logger.warn("Block '{}' not found for dimension '{}' - falling back to stone_bricks", entry.block, entry.dimension);
                        entry.block = "minecraft:stone_bricks";
                    }
                } else {
                    entry.block = "minecraft:stone_bricks";
                }

                if (entry.lightBlock != null && !entry.lightBlock.isBlank()) {
                    Identifier lightId = Identifier.parse(entry.lightBlock);
                    if (!BuiltInRegistries.BLOCK.containsKey(lightId)) {
                        logger.warn("Light block '{}' not found for dimension '{}' - falling back to sea_lantern", entry.lightBlock, entry.dimension);
                        entry.lightBlock = "minecraft:sea_lantern";
                    }
                } else {
                    entry.lightBlock = "minecraft:sea_lantern";
                }

                if (entry.accentBlock != null && !entry.accentBlock.isBlank()) {
                    Identifier accentId = Identifier.parse(entry.accentBlock);
                    if (!BuiltInRegistries.BLOCK.containsKey(accentId)) {
                        logger.warn("Accent block '{}' not found for dimension '{}' - falling back to dark_prismarine", entry.accentBlock, entry.dimension);
                        entry.accentBlock = "minecraft:dark_prismarine";
                    }
                } else {
                    entry.accentBlock = "minecraft:dark_prismarine";
                }

                if (entry.groundBlock != null && !entry.groundBlock.isBlank()) {
                    Identifier groundId = Identifier.parse(entry.groundBlock);
                    if (!BuiltInRegistries.BLOCK.containsKey(groundId)) {
                        logger.warn("Ground block '{}' not found for dimension '{}' - falling back to dirt", entry.groundBlock, entry.dimension);
                        entry.groundBlock = "minecraft:dirt";
                    }
                } else {
                    entry.groundBlock = "minecraft:dirt";
                }

                entries.add(entry);
                logger.info("Registered custom dimension '{}' with block '{}'", entry.dimension, entry.block);
            }
        } catch (IOException e) {
            logger.error("Could not read config file: {}", configFile, e);
        } catch (com.google.gson.JsonSyntaxException e) {
            logger.error("Invalid JSON in config file: {}", configFile, e);
        }
    }

    public static List<DimensionEntry> getEntries() {
        return entries;
    }

    private static void createDefaultConfig(Path configFile, Logger logger) {
        List<DimensionEntry> defaults = new ArrayList<>();
        DimensionEntry example = new DimensionEntry();
        example.dimension = "example:your_dimension";
        example.biomes = List.of("example:biome_id");
        example.block = "minecraft:stone_bricks";
        example.lightBlock = "minecraft:sea_lantern";
        example.accentBlock = "minecraft:dark_prismarine";
        example.groundBlock = "minecraft:dirt";
        defaults.add(example);

        try {
            String json = GSON.toJson(defaults);
            Files.writeString(configFile, json);
            logger.info("Created default config at {}", configFile);
            logger.info("Edit it to add your custom dimensions. See docs/custom_dimensions.md for details.");
        } catch (IOException e) {
            logger.error("Could not write default config", e);
        }
    }

    public static class DimensionEntry {
        private String dimension;
        private List<String> biomes;
        private String block;
        private String lightBlock;
        private String accentBlock;
        private String groundBlock;

        public String getDimension() { return dimension; }
        public List<String> getBiomes() { return biomes == null ? List.of() : biomes; }
        public String getBlock() { return block; }
        public String getLightBlock() { return lightBlock; }
        public String getAccentBlock() { return accentBlock; }
        public String getGroundBlock() { return groundBlock; }
    }
}
