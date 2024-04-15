package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.Event;

import net.eca.init.EpicCoreApiModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DivineWrathEnchantedItemAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getAmount(), event.getSource().getDirectEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double amount, Entity sourceEntity) {
		execute(null, world, entity, amount, sourceEntity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount, Entity sourceEntity) {
		if (entity == null || !(sourceEntity instanceof LivingEntity))
			return;
		LivingEntity attacker = (LivingEntity) sourceEntity;
		ItemStack weapon = attacker.getMainHandItem();
		if (EnchantmentHelper.getItemEnchantmentLevel(EpicCoreApiModEnchantments.DIVINE_WRATH.get(), weapon) > 0) {
			double attackerDamage = attacker.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue();
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)),
					(float) (attackerDamage));
		}
	}
}