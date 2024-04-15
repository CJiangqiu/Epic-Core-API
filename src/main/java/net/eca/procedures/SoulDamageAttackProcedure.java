package net.eca.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.eca.init.EpicCoreApiModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SoulDamageAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), (LivingEntity) event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LivingHurtEvent event, DamageSource damagesource, LivingEntity entity, float damage) {
		execute(null, event, damagesource, entity, damage);
	}

	private static void execute(@Nullable Event event, LivingHurtEvent hurtEvent, DamageSource damagesource, LivingEntity entity, float damage) {
		if (damagesource == null || entity == null)
			return;
		if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("epic_core_api:soul_damage")))) {
			for (ItemStack itemStack : entity.getArmorSlots()) {
				if (itemStack.isEnchanted() && EnchantmentHelper.getItemEnchantmentLevel(EpicCoreApiModEnchantments.SOUL_PROTECTION.get(), itemStack) > 0) {
					int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(EpicCoreApiModEnchantments.SOUL_PROTECTION.get(), itemStack);
					damage -= enchantmentLevel;
					if (damage <= 0) {
						break;
					}
				}
			}
			if (damage > 0) {
				entity.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue(entity.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() - damage);
			}
			hurtEvent.setAmount(damage);
		}
	}
}
