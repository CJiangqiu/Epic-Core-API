package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.eca.init.EpicCoreApiModAttributes;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration;

import javax.annotation.Nullable;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber
public class StaminaRecoverProcedure {
    private static final UUID STAMINA_MODIFIER_UUID = UUID.fromString("d1b8f843-69e9-486c-b174-a4e86d930aa5");
    private static HashMap<Entity, Integer> entityTickCounter = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player);
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        int tickCount = entityTickCounter.getOrDefault(entity, 0) + 1;
        if (tickCount >= 20) {
            double currentStamina = ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getValue();
            if (currentStamina < 0) {
                ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).setBaseValue(0);
            } else if (currentStamina < ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getBaseValue()) {
                AttributeModifier existingModifier = ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getModifier(STAMINA_MODIFIER_UUID);
                if (existingModifier != null) {
                    ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).removeModifier(STAMINA_MODIFIER_UUID);
                    ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
                            .addPermanentModifier(new AttributeModifier(STAMINA_MODIFIER_UUID, "stamina_recover", existingModifier.getAmount() + EpicCoreApiConfigurationConfiguration.STAMINA_RECOVER_VALUE.get(), AttributeModifier.Operation.ADDITION));
                } else {
                    ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
                            .addPermanentModifier(new AttributeModifier(STAMINA_MODIFIER_UUID, "stamina_recover", EpicCoreApiConfigurationConfiguration.STAMINA_RECOVER_VALUE.get(), AttributeModifier.Operation.ADDITION));
                }
            }
            entityTickCounter.put(entity, 0);
        } else {
            entityTickCounter.put(entity, tickCount);
        }
    }
}

