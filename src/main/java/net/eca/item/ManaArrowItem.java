
package net.eca.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ManaArrowItem extends Item {
	public ManaArrowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
