package com.skd.towerwaystone;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(WaystoneTowersMod.MODID)
public class WaystoneTowersMod {
    public static final String MODID = "tower_waystone";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, MODID);

    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<WaystoneNameProcessor>> WAYSTONE_NAME_PROCESSOR =
            STRUCTURE_PROCESSORS.register("waystone_name",
                    () -> new StructureProcessorType<>() {
                        @Override
                        public com.mojang.serialization.MapCodec<WaystoneNameProcessor> codec() {
                            return WaystoneNameProcessor.CODEC;
                        }
                    });

    public WaystoneTowersMod(IEventBus modEventBus) {
        STRUCTURE_PROCESSORS.register(modEventBus);
        LOGGER.info("Tower Waystone loaded!");
    }
}
