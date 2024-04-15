
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.eca.client.model.Modelmagic_arrow;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EpicCoreApiModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmagic_arrow.LAYER_LOCATION, Modelmagic_arrow::createBodyLayer);
	}
}
