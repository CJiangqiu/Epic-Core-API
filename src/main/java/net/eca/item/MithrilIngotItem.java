
package net.eca.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MithrilIngotItem extends Item {
	public MithrilIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
