package net.eca.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.eca.network.EpicCoreApiModVariables;

public class HeavyAttackUnlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).skill_points >= 1) {
			{
				double _setval = (entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).skill_points - 1;
				entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skill_points = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("epic_core_api:skill_point_use")), SoundSource.VOICE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("epic_core_api:skill_point_use")), SoundSource.VOICE, 1, 1, false);
				}
			}
			{
				boolean _setval = true;
				entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.heavy_attack = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
