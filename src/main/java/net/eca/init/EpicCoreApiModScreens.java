
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.eca.client.gui.SkillPointsGuiScreen;
import net.eca.client.gui.MithrilBlastFurnaceGuiScreen;
import net.eca.client.gui.EditStaminaManaOverlayScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicCoreApiModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EpicCoreApiModMenus.MITHRIL_BLAST_FURNACE_GUI.get(), MithrilBlastFurnaceGuiScreen::new);
			MenuScreens.register(EpicCoreApiModMenus.EDIT_STAMINA_MANA_OVERLAY.get(), EditStaminaManaOverlayScreen::new);
			MenuScreens.register(EpicCoreApiModMenus.SKILL_POINTS_GUI.get(), SkillPointsGuiScreen::new);
		});
	}
}
