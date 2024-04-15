
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.eca.client.particle.BurningParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicCoreApiModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(EpicCoreApiModParticleTypes.BURNING_PARTICLE.get(), BurningParticleParticle::provider);
	}
}
