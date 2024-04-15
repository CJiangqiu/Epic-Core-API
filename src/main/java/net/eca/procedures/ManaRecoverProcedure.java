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
public class ManaRecoverProcedure {
    private static final UUID MANA_MODIFIER_UUID = UUID.fromString("68b2188e-0825-4458-b2f3-a9f6801b6b7b");
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
            if (((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getValue() < ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getBaseValue()) {
                AttributeModifier existingModifier = ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getModifier(MANA_MODIFIER_UUID);
                if (existingModifier != null) {
                    ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).removeModifier(MANA_MODIFIER_UUID);
                    ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get())
                            .addPermanentModifier(new AttributeModifier(MANA_MODIFIER_UUID, "mana_recover", existingModifier.getAmount() + EpicCoreApiConfigurationConfiguration.MANA_RECOVER_VALUE.get(), AttributeModifier.Operation.ADDITION));
                } else {
                    ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get())
                            .addPermanentModifier(new AttributeModifier(MANA_MODIFIER_UUID, "mana_recover", EpicCoreApiConfigurationConfiguration.MANA_RECOVER_VALUE.get(), AttributeModifier.Operation.ADDITION));
                }
            }
            entityTickCounter.put(entity, 0);
        } else {
            entityTickCounter.put(entity, tickCount);
        }
    }
}
