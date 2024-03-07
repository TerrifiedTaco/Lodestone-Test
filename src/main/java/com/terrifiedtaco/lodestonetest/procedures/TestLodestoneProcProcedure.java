package com.terrifiedtaco.lodestonetest.procedures;

import net.minecraft.client.*;
import net.minecraft.client.player.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import team.lodestar.lodestone.registry.common.particle.*;
import team.lodestar.lodestone.systems.easing.*;
import team.lodestar.lodestone.systems.particle.builder.*;
import team.lodestar.lodestone.systems.particle.data.*;
import team.lodestar.lodestone.systems.particle.data.color.*;
import team.lodestar.lodestone.systems.particle.data.spin.*;

import java.awt.Color;

public class TestLodestoneProcProcedure {
	public static void execute() {
		final LocalPlayer player = Minecraft.getInstance().player;
		if (player != null) {
			Vec3 pos = player.position();
			Color startingColor = new Color(100, 0, 100);
	        Color endingColor = new Color(0, 100, 200);
	        WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
	                .setScaleData(GenericParticleData.create(0.5f, 0).build())
	                .setTransparencyData(GenericParticleData.create(0.75f, 0.25f).build())
	                .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
	                .setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((player.level().getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
	                .setLifetime(40)
	                .addMotion(0, 0.01f, 0)
	                .enableNoClip()
	                .spawn(player.level(), pos.x, pos.y, pos.z);
		}
	}
}
