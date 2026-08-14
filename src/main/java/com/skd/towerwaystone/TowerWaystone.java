package com.skd.towerwaystone;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

@Mod(TowerWaystone.MODID)
public class TowerWaystone {
    public static final String MODID = "tower_waystone";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TowerWaystone(IEventBus modEventBus) {
        CustomDimensionConfig.load(FMLPaths.CONFIGDIR.get(), LOGGER);
        WaystoneBeaconConfig.load(FMLPaths.CONFIGDIR.get(), LOGGER);

        NeoForge.EVENT_BUS.register(new WaystoneNamer());
        modEventBus.addListener(DynamicStructureRegistry::onRegister);
        modEventBus.addListener(this::onClientSetup);

        LOGGER.info("Tower Waystone loaded!");
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        NeoForge.EVENT_BUS.register(new WaystoneBeaconClientData());
        NeoForge.EVENT_BUS.register(new WaystoneBeaconRenderer());
    }
}