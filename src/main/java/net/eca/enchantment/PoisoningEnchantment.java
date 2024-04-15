/*Poisoning Enchantment: This is a custom enchantment that inflicts poison on the entity being attacked. The poison level is one less than the enchantment level, and the duration of the poison effect is 2 seconds for the first level of enchantment, with an additional 2 seconds for each subsequent level. 
淬毒附魔：这是一种自定义附魔，它会对被攻击的实体施加中毒效果。中毒等级比附魔等级低一级，中毒效果的持续时间为附魔第一级的2秒，之后每一级增加2秒。 */

package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration; 


public class PoisoningEnchantment extends Enchantment {
	public PoisoningEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return EpicCoreApiConfigurationConfiguration.MAXIMUM_ENCHANTMENT_LEVEL.get().intValue(); 
	}
}
