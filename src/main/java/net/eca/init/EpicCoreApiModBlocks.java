
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.eca.block.SteelBlockBlock;
import net.eca.block.SilverOreBlock;
import net.eca.block.SilverBlockBlock;
import net.eca.block.OrichalcumBlockBlock;
import net.eca.block.MithrilOreBlock;
import net.eca.block.MithrilBlockBlock;
import net.eca.block.MithrilBlastFurnaceBlock;
import net.eca.block.ElderMetalWreckageBlock;
import net.eca.block.BlackCopperBlockBlock;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EpicCoreApiMod.MODID);
	public static final RegistryObject<Block> SILVER_ORE = REGISTRY.register("silver_ore", () -> new SilverOreBlock());
	public static final RegistryObject<Block> SILVER_BLOCK = REGISTRY.register("silver_block", () -> new SilverBlockBlock());
	public static final RegistryObject<Block> STEEL_BLOCK = REGISTRY.register("steel_block", () -> new SteelBlockBlock());
	public static final RegistryObject<Block> BLACK_COPPER_BLOCK = REGISTRY.register("black_copper_block", () -> new BlackCopperBlockBlock());
	public static final RegistryObject<Block> MITHRIL_ORE = REGISTRY.register("mithril_ore", () -> new MithrilOreBlock());
	public static final RegistryObject<Block> MITHRIL_BLOCK = REGISTRY.register("mithril_block", () -> new MithrilBlockBlock());
	public static final RegistryObject<Block> ELDER_METAL_WRECKAGE = REGISTRY.register("elder_metal_wreckage", () -> new ElderMetalWreckageBlock());
	public static final RegistryObject<Block> MITHRIL_BLAST_FURNACE = REGISTRY.register("mithril_blast_furnace", () -> new MithrilBlastFurnaceBlock());
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = REGISTRY.register("orichalcum_block", () -> new OrichalcumBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
