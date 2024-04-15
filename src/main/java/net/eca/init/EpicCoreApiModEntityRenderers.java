
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.eca.client.renderer.ShotManaArrowRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicCoreApiModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EpicCoreApiModEntities.SHOT_MANA_ARROW.get(), ShotManaArrowRenderer::new);
	}
}
