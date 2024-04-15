package net.eca.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.eca.init.EpicCoreApiModAttributes;

public class SkillPointsGetProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("translation.key.skill_points_number").getString() + "" + ("" + ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.SKILLPOINTS.get()).getValue());
	}
}
