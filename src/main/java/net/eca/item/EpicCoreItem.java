
package net.eca.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EpicCoreItem extends Item {
	public EpicCoreItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}
}
