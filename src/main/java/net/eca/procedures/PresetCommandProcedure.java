package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.eca.configuration.EpicCoreApiConfigurationConfiguration;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PresetCommandProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (EpicCoreApiConfigurationConfiguration.ENABLE_PRESET_COMMAND.get()) {
			if (world instanceof ServerLevel _level) {
				String presetCommandsString = EpicCoreApiConfigurationConfiguration.PRESET_COMMAND.get();
				List<String> presetCommands = Arrays.asList(presetCommandsString.split(";"));
				for (String command : presetCommands) {
					command = command.trim();  
					if (!command.isEmpty()) {
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), command);
					}
				}
				EpicCoreApiConfigurationConfiguration.ENABLE_PRESET_COMMAND.set(false);
			}
		}
	}
}


