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
import java.util.Objects;

public class WaystoneBeaconConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Settings SETTINGS;

    public static void load(Path configDir, Logger logger) {
        Path configFile = configDir.resolve("tower_waystone/waystone_beacon.json");
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
            Settings settings = GSON.fromJson(reader, Settings.class);
            if (settings == null) {
                logger.warn("Could not parse waystone_beacon.json, using default config");
                SETTINGS = new Settings();
                return;
            }
            // Validate and apply defaults for invalid values
            if (settings.color == null || settings.color.length != 3) {
                logger.warn("Invalid color in waystone_beacon.json, using default");
                settings.color = new int[]{80, 200, 255};
            } else {
                for (int i = 0; i < 3; i++) {
                    if (settings.color[i] < 0 || settings.color[i] > 255) {
                        logger.warn("Color value out of range in waystone_beacon.json, using default");
                        settings.color = new int[]{80, 200, 255};
                        break;
                    }
                }
            }
            if (settings.height <= 0) {
                logger.warn("Invalid height in waystone_beacon.json, using default");
                settings.height = new Settings().height;
            }
            SETTINGS = settings;
        } catch (IOException e) {
            logger.error("Could not read config file: {}", configFile, e);
            SETTINGS = new Settings();
        } catch (com.google.gson.JsonSyntaxException e) {
            logger.error("Invalid JSON in config file: {}", configFile, e);
            SETTINGS = new Settings();
        }
    }

    public static Settings getSettings() {
        return SETTINGS != null ? SETTINGS : new Settings();
    }

    private static void createDefaultConfig(Path configFile, Logger logger) {
        Settings defaults = new Settings();
        try {
            String json = GSON.toJson(defaults);
            Files.writeString(configFile, json);
            logger.info("Created default config at {}", configFile);
        } catch (IOException e) {
            logger.error("Could not write default config", e);
        }
    }

    public static class Settings {
        public boolean enabled = true;
        public int[] color = {80, 200, 255}; // RGB
        public int height = 100; // blocks

        public boolean isEnabled() {
            return enabled;
        }

        public int[] getColor() {
            return color.clone();
        }

        public int getHeight() {
            return height;
        }
    }
}