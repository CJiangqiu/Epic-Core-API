
package net.eca.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.eca.init.EpicCoreApiModJeiPlugin;
import net.eca.init.EpicCoreApiModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;
import net.minecraft.network.chat.Component;


public class MithrilBlastFurnaceSmeltingRecipeCategory implements IRecipeCategory<MithrilBlastFurnaceSmeltingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("epic_core_api", "mithril_blast_furnace_smelting");
	public final static ResourceLocation TEXTURE = new ResourceLocation("epic_core_api", "textures/screens/mbf_jei_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public MithrilBlastFurnaceSmeltingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 200, 180);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EpicCoreApiModBlocks.MITHRIL_BLAST_FURNACE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<MithrilBlastFurnaceSmeltingRecipe> getRecipeType() {
		return EpicCoreApiModJeiPlugin.MithrilBlastFurnaceSmelting_Type;
	}

	@Override
	public Component getTitle() {
    	return Component.translatable("jei.receipe_type.mithril_blast_furnace_smelting");
	}


	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MithrilBlastFurnaceSmeltingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 55, 22).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 127, 41).addItemStack(recipe.getResultItem(null));
	}
}
