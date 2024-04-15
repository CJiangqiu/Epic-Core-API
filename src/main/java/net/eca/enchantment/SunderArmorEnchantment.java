
package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration; 

public class SunderArmorEnchantment extends Enchantment {
	public SunderArmorEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return EpicCoreApiConfigurationConfiguration.MAXIMUM_ENCHANTMENT_LEVEL.get().intValue(); 
	}
}
