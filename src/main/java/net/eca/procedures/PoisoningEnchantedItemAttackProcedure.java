package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import net.eca.init.EpicCoreApiModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PoisoningEnchantedItemAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity) {
			ItemStack itemUsed = ((LivingEntity) sourceentity).getMainHandItem();
			if (EnchantmentHelper.getItemEnchantmentLevel(EpicCoreApiModEnchantments.POISONING.get(), itemUsed) != 0) {
				int enchantmentLevel = itemUsed.getEnchantmentLevel(EpicCoreApiModEnchantments.POISONING.get());
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 20 * enchantmentLevel, enchantmentLevel-1));
			}
		}
	}
}
