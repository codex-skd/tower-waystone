package com.skd.towerwaystone;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ARGB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.SubmitCustomGeometryEvent;

import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class WaystoneBeaconRenderer {

    @SubscribeEvent
    public void onSubmitCustomGeometry(SubmitCustomGeometryEvent event) {
        WaystoneBeaconConfig.Settings settings = WaystoneBeaconConfig.getSettings();
        if (!settings.isEnabled()) return;

        Set<BlockPos> waystonePositions = WaystoneBeaconClientData.getWaystonePositions();
        if (waystonePositions.isEmpty()) return;

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) return;

        Vec3 cameraPos = minecraft.gameRenderer.mainCamera().position();
        long gameTime = minecraft.level.getGameTime();
        float animationTime = Math.floorMod(gameTime, 40);

        int[] colorRGB = settings.getColor();
        int color = ARGB.color(colorRGB[0], colorRGB[1], colorRGB[2]);
        int height = settings.getHeight();

        PoseStack poseStack = event.getPoseStack();

        for (BlockPos pos : waystonePositions) {
            poseStack.pushPose();
            poseStack.translate(pos.getX() - cameraPos.x, pos.getY() - cameraPos.y, pos.getZ() - cameraPos.z);
            BeaconRenderer.submitBeaconBeam(
                    poseStack,
                    event.getSubmitNodeCollector(),
                    BeaconRenderer.BEAM_LOCATION,
                    1.0F,
                    animationTime,
                    0,
                    height,
                    color,
                    0.2F,
                    0.25F
            );
            poseStack.popPose();
        }
    }
}
