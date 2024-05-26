package net.eca.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import net.eca.network.EpicCoreApiModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SkillPointsCommandCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("skillpoints").requires(s -> s.hasPermission(1))
            .then(Commands.argument("operation", StringArgumentType.word())
                .suggests((context, builder) -> {
                    builder.suggest("set");
                    return builder.buildFuture();
                })
                .then(Commands.argument("number", DoubleArgumentType.doubleArg()).executes(arguments -> {
                    Entity entity = arguments.getSource().getEntity();
                    execute(arguments, StringArgumentType.getString(arguments, "operation"), entity);
                    return 0;
                }))));
    }

    public static void execute(CommandContext<CommandSourceStack> arguments, String operation, Entity entity) {
        if (entity == null)
            return;
        double _setval = DoubleArgumentType.getDouble(arguments, "number");
        if (operation.equals("set")) {
            entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.skill_points = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
