package net.eca.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.eca.init.EpicCoreApiModAttributes;

import java.util.UUID;

public class MasterOfRangedWeaponsUnlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.SKILLPOINTS.get()).getValue() >= 1) {
			((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.SKILLPOINTS.get())
					.addPermanentModifier((new AttributeModifier(UUID.fromString("e51da488-1015-11ef-92db-325096b39f47"), "skill_points_reduce", (-1), AttributeModifier.Operation.ADDITION)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.chime")), SoundSource.VOICE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.chime")), SoundSource.VOICE, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("master_of_ranged_weapons", true);
		}
	}
}
