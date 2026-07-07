package com.skd.towerwaystone;

import com.mojang.logging.LogUtils;
import com.skd.towerwaystone.world.features.StructureFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(WaystoneTowersMod.MODID)
public class WaystoneTowersMod {
    public static final String MODID = "waystone_towers";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WaystoneTowersMod(IEventBus modEventBus) {
        StructureFeature.REGISTRY.register(modEventBus);
        LOGGER.info("Waystone Towers loaded!");
    }
}
