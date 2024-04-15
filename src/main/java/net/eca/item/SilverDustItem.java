
package net.eca.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SilverDustItem extends Item {
	public SilverDustItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
