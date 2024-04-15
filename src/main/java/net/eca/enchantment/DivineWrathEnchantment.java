/*The original damage type of weapon is replaced by void damage.
 * 武器原始的伤害类型将被替换为虚空伤害。
 */
package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class DivineWrathEnchantment extends Enchantment {
	public DivineWrathEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public int getMinCost(int enchantmentLevel) {

		return 30;
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
	
		return 30;
	}

	@Override
	public int getMaxLevel() {
	
		return 1;
	}
}