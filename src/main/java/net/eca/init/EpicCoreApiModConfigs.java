package net.eca.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.eca.configuration.EpicCoreApiConfigurationConfiguration;
import net.eca.EpicCoreApiMod;

@Mod.EventBusSubscriber(modid = EpicCoreApiMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EpicCoreApiModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EpicCoreApiConfigurationConfiguration.SPEC, "Epic Core API Configuration.toml");
		});
	}
}
