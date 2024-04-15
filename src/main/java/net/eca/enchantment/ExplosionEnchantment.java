
package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration; 

public class ExplosionEnchantment extends Enchantment {
	public ExplosionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BOW, slots);
	}

	@Override
	public int getMaxLevel() {
		return EpicCoreApiConfigurationConfiguration.MAXIMUM_ENCHANTMENT_LEVEL.get().intValue(); 
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(ItemTags.create(new ResourceLocation("forge:weapons/ranged_weapon"))).test(itemstack);
	}
}
