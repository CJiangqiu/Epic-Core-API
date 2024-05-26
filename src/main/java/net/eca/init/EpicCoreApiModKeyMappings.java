
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

import net.eca.network.CombatSkillsButtonMessage;
import net.eca.network.CombatSkillButtonMessage;
import net.eca.EpicCoreApiMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EpicCoreApiModKeyMappings {
	public static final KeyMapping COMBAT_SKILLS_BUTTON = new KeyMapping("key.epic_core_api.combat_skills_button", GLFW.GLFW_KEY_LEFT_CONTROL, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EpicCoreApiMod.PACKET_HANDLER.sendToServer(new CombatSkillsButtonMessage(0, 0));
				CombatSkillsButtonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping COMBAT_SKILL_BUTTON = new KeyMapping("key.epic_core_api.combat_skill_button", GLFW.GLFW_KEY_I, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EpicCoreApiMod.PACKET_HANDLER.sendToServer(new CombatSkillButtonMessage(0, 0));
				CombatSkillButtonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(COMBAT_SKILLS_BUTTON);
		event.register(COMBAT_SKILL_BUTTON);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				COMBAT_SKILLS_BUTTON.consumeClick();
				COMBAT_SKILL_BUTTON.consumeClick();
			}
		}
	}
}
