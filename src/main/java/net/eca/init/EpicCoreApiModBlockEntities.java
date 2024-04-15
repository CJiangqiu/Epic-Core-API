
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.eca.block.entity.OrichalcumBlockBlockEntity;
import net.eca.block.entity.MithrilBlastFurnaceBlockEntity;
import net.eca.block.entity.ElderMetalWreckageBlockEntity;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EpicCoreApiMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ELDER_METAL_WRECKAGE = register("elder_metal_wreckage", EpicCoreApiModBlocks.ELDER_METAL_WRECKAGE, ElderMetalWreckageBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MITHRIL_BLAST_FURNACE = register("mithril_blast_furnace", EpicCoreApiModBlocks.MITHRIL_BLAST_FURNACE, MithrilBlastFurnaceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ORICHALCUM_BLOCK = register("orichalcum_block", EpicCoreApiModBlocks.ORICHALCUM_BLOCK, OrichalcumBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
