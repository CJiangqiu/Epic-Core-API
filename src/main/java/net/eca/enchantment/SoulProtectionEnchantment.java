
package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.damagesource.DamageSource;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration; 

public class SoulProtectionEnchantment extends Enchantment {
	public SoulProtectionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public int getMaxLevel() {
		return EpicCoreApiConfigurationConfiguration.MAXIMUM_ENCHANTMENT_LEVEL.get().intValue(); 
	}

}
