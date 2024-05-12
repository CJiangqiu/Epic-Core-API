package net.eca.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;

import net.eca.init.EpicCoreApiModAttributes;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.CommandDispatcher;

import java.util.Arrays;
import java.util.UUID;

@Mod.EventBusSubscriber
public class SkillPointsCommandCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("skillpoints").requires(s -> s.hasPermission(1))
    .then(Commands.argument("operation", StringArgumentType.word())
        .suggests((context, builder) -> {
            builder.suggest("add");
            builder.suggest("reduce");
            return builder.buildFuture();
        })
        .then(Commands.argument("number", DoubleArgumentType.doubleArg()).executes(arguments -> {
            Level world = arguments.getSource().getUnsidedLevel();
            double x = arguments.getSource().getPosition().x();
            double y = arguments.getSource().getPosition().y();
            double z = arguments.getSource().getPosition().z();
            Entity entity = arguments.getSource().getEntity();
            if (entity == null && world instanceof ServerLevel _servLevel)
                entity = FakePlayerFactory.getMinecraft(_servLevel);
            Direction direction = Direction.DOWN;
            if (entity != null)
                direction = entity.getDirection();

            execute(arguments, StringArgumentType.getString(arguments, "operation"), entity);
            return 0;
        }))));

    }

    public static void execute(CommandContext<CommandSourceStack> arguments, String operation, Entity entity) {
    if (entity == null)
        return;
    UUID modifierUUID = UUID.randomUUID();
    if (operation.equals("add")) {
        ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.SKILLPOINTS.get())
                .addPermanentModifier((new AttributeModifier(modifierUUID, "skill_points_add", (DoubleArgumentType.getDouble(arguments, "number")), AttributeModifier.Operation.ADDITION)));
    }
    if (operation.equals("reduce")) {
        ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.SKILLPOINTS.get())
                .addPermanentModifier((new AttributeModifier(modifierUUID, "skill_points_reduce", (DoubleArgumentType.getDouble(arguments, "number") * (-1)), AttributeModifier.Operation.ADDITION)));
    }
}

}

