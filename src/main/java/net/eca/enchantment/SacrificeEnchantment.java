/*Reduce the maximum health of the attacked entity by the enchantment level.
减少被攻击实体附魔等级的最大生命值。
*/

package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration;

public class SacrificeEnchantment extends Enchantment {
	public SacrificeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return EpicCoreApiConfigurationConfiguration.MAXIMUM_ENCHANTMENT_LEVEL.get().intValue(); 
	}
}
