
package net.eca.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlackCopperIngotUpgradeSmithingTemplateItem extends Item {
	public BlackCopperIngotUpgradeSmithingTemplateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
