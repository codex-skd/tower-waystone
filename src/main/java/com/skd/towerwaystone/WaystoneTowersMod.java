package com.skd.towerwaystone;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(WaystoneTowersMod.MODID)
public class WaystoneTowersMod {
    public static final String MODID = "tower_waystone";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WaystoneTowersMod(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.register(new WaystoneNamer());
        LOGGER.info("Tower Waystone loaded!");
    }
}
