
package net.eca.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class EpicCoreApiModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("epic_core_api:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModItems.STEEL_INGOT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.steel_ingot_jei_information"));
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModItems.STEEL_HAMMER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.steel_hammer_jei_information"));
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModBlocks.SILVER_ORE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.silver_ore_jei_information"));
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModBlocks.MITHRIL_ORE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.mithril_ore_jei_information"));
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModBlocks.MITHRIL_BLAST_FURNACE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.mithril_blast_furnace_jei_information"));
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModBlocks.ELDER_METAL_WRECKAGE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.elder_metal_wreckage_jei_information"));
		registration.addIngredientInfo(List.of(new ItemStack(EpicCoreApiModItems.RAW_SILVER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.epic_core_api.raw_silver_jei_information"));
	}
}
