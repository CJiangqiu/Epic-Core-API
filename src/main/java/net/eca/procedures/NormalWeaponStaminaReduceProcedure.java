/*
 * 
 package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.eca.init.EpicCoreApiModAttributes;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class NormalWeaponStaminaReduceProcedure {
    private static final UUID STAMINA_MODIFIER_UUID = UUID.fromString("38009820-6991-405a-a6c2-5109eb28ddc2");

    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getSource().getEntity());
        }
    }

    public static void execute(Entity sourceentity) {
        execute(null, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getValue() >= 5) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/normal_weapon")))) {
                AttributeModifier existingModifier = ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getModifier(STAMINA_MODIFIER_UUID);
                if (existingModifier != null) {
                    ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).removeModifier(STAMINA_MODIFIER_UUID);
                    ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
                            .addPermanentModifier(new AttributeModifier(STAMINA_MODIFIER_UUID, "stamina_reduce", existingModifier.getAmount() - 5, AttributeModifier.Operation.ADDITION));
                } else {
                    ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
                            .addPermanentModifier(new AttributeModifier(STAMINA_MODIFIER_UUID, "stamina_reduce", -5, AttributeModifier.Operation.ADDITION));
                }
            }
        }
    }
}
*/
