
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.eca.network.StaminaManaOverlayRemoveMessage;
import net.eca.network.SkillPointsGuiButtonMessage;
import net.eca.EpicCoreApiMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EpicCoreApiModKeyMappings {
	public static final KeyMapping SKILL_POINTS_GUI_BUTTON = new KeyMapping("key.epic_core_api.skill_points_gui_button", GLFW.GLFW_KEY_I, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EpicCoreApiMod.PACKET_HANDLER.sendToServer(new SkillPointsGuiButtonMessage(0, 0));
				SkillPointsGuiButtonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping STAMINA_MANA_OVERLAY_REMOVE = new KeyMapping("key.epic_core_api.stamina_mana_overlay_remove", GLFW.GLFW_KEY_O, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EpicCoreApiMod.PACKET_HANDLER.sendToServer(new StaminaManaOverlayRemoveMessage(0, 0));
				StaminaManaOverlayRemoveMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SKILL_POINTS_GUI_BUTTON);
		event.register(STAMINA_MANA_OVERLAY_REMOVE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SKILL_POINTS_GUI_BUTTON.consumeClick();
				STAMINA_MANA_OVERLAY_REMOVE.consumeClick();
			}
		}
	}
}
