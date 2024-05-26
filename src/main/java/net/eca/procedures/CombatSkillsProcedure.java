package net.eca.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.eca.network.EpicCoreApiModVariables;
import net.eca.init.EpicCoreApiModAttributes;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration;

public class CombatSkillsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EpicCoreApiConfigurationConfiguration.ENABLE_BATTLE_SYSTEM.get() == true) {
			if (((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getValue() >= 10
					&& (entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).charge_attack == true) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/normal_weapon")))
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/normal_weapon")))) {
					ChargeAttackProcedure.execute(world, entity);
				}
			}
			if (((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getValue() >= 20
					&& (entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).heavy_attack == true) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/giant_weapon")))
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/giant_weapon")))
								&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					HeavyAttackProcedure.execute(world, entity);
				}
			}
			if (((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getValue() >= 10 && entity.getPersistentData().getBoolean("shield_smite") == true) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/shield")))
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/shield")))) {
					ShieldSmiteProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
