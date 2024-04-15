package net.eca.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.eca.jei_recipes.MithrilBlastFurnaceSmeltingRecipe;
import net.eca.EpicCoreApiMod;

@Mod.EventBusSubscriber(modid = EpicCoreApiMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EpicCoreApiModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "epic_core_api");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("mithril_blast_furnace_smelting", () -> MithrilBlastFurnaceSmeltingRecipe.Serializer.INSTANCE);
		});
	}
}
