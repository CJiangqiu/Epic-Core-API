package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.eca.init.EpicCoreApiModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaTextShowProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static String execute(Entity entity) {
		return execute(null, entity);
	}

	private static String execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return "";
		return Math.ceil(((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getValue()) + "" + ("/" + Math.ceil(((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getBaseValue()));
	}
}
