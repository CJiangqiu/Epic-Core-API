package net.eca.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.eca.network.EpicCoreApiModVariables;

public class SkillPointsGetProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("translation.key.skill_points_number").getString() + "" + (entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).skill_points;
	}
}
