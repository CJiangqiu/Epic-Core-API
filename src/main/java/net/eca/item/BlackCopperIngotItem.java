
package net.eca.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlackCopperIngotItem extends Item {
	public BlackCopperIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
