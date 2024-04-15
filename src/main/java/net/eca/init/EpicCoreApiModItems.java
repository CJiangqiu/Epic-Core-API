
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.eca.item.SteelIngotItem;
import net.eca.item.SteelHammerItem;
import net.eca.item.SilverIngotItem;
import net.eca.item.SilverDustItem;
import net.eca.item.RawSilverItem;
import net.eca.item.OrichalcumIngotItem;
import net.eca.item.MithrilIngotItem;
import net.eca.item.ManaArrowItem;
import net.eca.item.GoldSilverMixedDustItem;
import net.eca.item.GoldDustItem;
import net.eca.item.EpicCoreItem;
import net.eca.item.BlackCopperIngotUpgradeSmithingTemplateItem;
import net.eca.item.BlackCopperIngotItem;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EpicCoreApiMod.MODID);
	public static final RegistryObject<Item> SILVER_DUST = REGISTRY.register("silver_dust", () -> new SilverDustItem());
	public static final RegistryObject<Item> SILVER_ORE = block(EpicCoreApiModBlocks.SILVER_ORE);
	public static final RegistryObject<Item> SILVER_BLOCK = block(EpicCoreApiModBlocks.SILVER_BLOCK);
	public static final RegistryObject<Item> SILVER_INGOT = REGISTRY.register("silver_ingot", () -> new SilverIngotItem());
	public static final RegistryObject<Item> STEEL_INGOT = REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> STEEL_HAMMER = REGISTRY.register("steel_hammer", () -> new SteelHammerItem());
	public static final RegistryObject<Item> STEEL_BLOCK = block(EpicCoreApiModBlocks.STEEL_BLOCK);
	public static final RegistryObject<Item> EPIC_CORE = REGISTRY.register("epic_core", () -> new EpicCoreItem());
	public static final RegistryObject<Item> GOLD_DUST = REGISTRY.register("gold_dust", () -> new GoldDustItem());
	public static final RegistryObject<Item> GOLD_SILVER_MIXED_DUST = REGISTRY.register("gold_silver_mixed_dust", () -> new GoldSilverMixedDustItem());
	public static final RegistryObject<Item> BLACK_COPPER_INGOT = REGISTRY.register("black_copper_ingot", () -> new BlackCopperIngotItem());
	public static final RegistryObject<Item> BLACK_COPPER_INGOT_UPGRADE_SMITHING_TEMPLATE = REGISTRY.register("black_copper_ingot_upgrade_smithing_template", () -> new BlackCopperIngotUpgradeSmithingTemplateItem());
	public static final RegistryObject<Item> BLACK_COPPER_BLOCK = block(EpicCoreApiModBlocks.BLACK_COPPER_BLOCK);
	public static final RegistryObject<Item> MITHRIL_INGOT = REGISTRY.register("mithril_ingot", () -> new MithrilIngotItem());
	public static final RegistryObject<Item> MITHRIL_ORE = block(EpicCoreApiModBlocks.MITHRIL_ORE);
	public static final RegistryObject<Item> MITHRIL_BLOCK = block(EpicCoreApiModBlocks.MITHRIL_BLOCK);
	public static final RegistryObject<Item> ELDER_METAL_WRECKAGE = block(EpicCoreApiModBlocks.ELDER_METAL_WRECKAGE);
	public static final RegistryObject<Item> RAW_SILVER = REGISTRY.register("raw_silver", () -> new RawSilverItem());
	public static final RegistryObject<Item> ORICHALCUM_INGOT = REGISTRY.register("orichalcum_ingot", () -> new OrichalcumIngotItem());
	public static final RegistryObject<Item> MITHRIL_BLAST_FURNACE = block(EpicCoreApiModBlocks.MITHRIL_BLAST_FURNACE);
	public static final RegistryObject<Item> ORICHALCUM_BLOCK = block(EpicCoreApiModBlocks.ORICHALCUM_BLOCK);
	public static final RegistryObject<Item> MANA_ARROW = REGISTRY.register("mana_arrow", () -> new ManaArrowItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
