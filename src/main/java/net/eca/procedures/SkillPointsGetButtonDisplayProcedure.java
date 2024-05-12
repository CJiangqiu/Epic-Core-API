package net.eca.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.eca.init.EpicCoreApiModAttributes;

import java.util.UUID;

public class SkillPointsGetButtonDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 10) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(-(160));
			((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.SKILLPOINTS.get()).addPermanentModifier((new AttributeModifier(UUID.randomUUID(), "skill_point_addition", 1, AttributeModifier.Operation.ADDITION)));
			return true;
		}
		return false;
	}
}
