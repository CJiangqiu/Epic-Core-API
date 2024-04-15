
package net.eca.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.eca.jei_recipes.MithrilBlastFurnaceSmeltingRecipeCategory;
import net.eca.jei_recipes.MithrilBlastFurnaceSmeltingRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class EpicCoreApiModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<MithrilBlastFurnaceSmeltingRecipe> MithrilBlastFurnaceSmelting_Type = new mezz.jei.api.recipe.RecipeType<>(MithrilBlastFurnaceSmeltingRecipeCategory.UID, MithrilBlastFurnaceSmeltingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("epic_core_api:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new MithrilBlastFurnaceSmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<MithrilBlastFurnaceSmeltingRecipe> MithrilBlastFurnaceSmeltingRecipes = recipeManager.getAllRecipesFor(MithrilBlastFurnaceSmeltingRecipe.Type.INSTANCE);
		registration.addRecipes(MithrilBlastFurnaceSmelting_Type, MithrilBlastFurnaceSmeltingRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(EpicCoreApiModBlocks.MITHRIL_BLAST_FURNACE.get().asItem()), MithrilBlastFurnaceSmelting_Type);
	}
}
