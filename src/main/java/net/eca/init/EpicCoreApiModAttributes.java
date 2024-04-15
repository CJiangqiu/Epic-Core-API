/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.eca.EpicCoreApiMod;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EpicCoreApiModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, EpicCoreApiMod.MODID);
	public static final RegistryObject<Attribute> STAMINA = ATTRIBUTES.register("stamina", () -> (new RangedAttribute("attribute." + EpicCoreApiMod.MODID + ".stamina", 100, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> MANA = ATTRIBUTES.register("mana", () -> (new RangedAttribute("attribute." + EpicCoreApiMod.MODID + ".mana", 100, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> SKILLPOINTS = ATTRIBUTES.register("skill_points", () -> (new RangedAttribute("attribute." + EpicCoreApiMod.MODID + ".skill_points", 0, 0, 100)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		List<EntityType<? extends LivingEntity>> entityTypes = event.getTypes();
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, STAMINA.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, MANA.get());
			}
		});
		event.add(EntityType.PLAYER, SKILLPOINTS.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(SKILLPOINTS.get()).setBaseValue(oldP.getAttribute(SKILLPOINTS.get()).getBaseValue());
		}
	}
}
