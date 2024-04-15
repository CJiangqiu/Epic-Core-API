
package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.eca.init.EpicCoreApiModAttributes;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class MagicWeaponManaReduceProcedure {
    private static final UUID MANA_MODIFIER_UUID = UUID.fromString("7bd5e389-46c2-497c-b7c5-7c2540fd8a53");

    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, ((Projectile)event.getEntity()).getOwner());
        }
    }

    public static void execute(Entity sourceentity) {
        execute(null, sourceentity);
    }

    public static void execute(@Nullable Event event, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getValue() >= 5) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/magic_weapon")))) {
                AttributeModifier existingModifier = ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getModifier(MANA_MODIFIER_UUID);
                if (existingModifier != null) {
                    ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.MANA.get()).removeModifier(MANA_MODIFIER_UUID);
                    ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.MANA.get())
                            .addPermanentModifier(new AttributeModifier(MANA_MODIFIER_UUID, "mana_reduce", existingModifier.getAmount() - 5, AttributeModifier.Operation.ADDITION));
                } else {
                    ((LivingEntity) sourceentity).getAttribute(EpicCoreApiModAttributes.MANA.get())
                            .addPermanentModifier(new AttributeModifier(MANA_MODIFIER_UUID, "mana_reduce", -5, AttributeModifier.Operation.ADDITION));
                }
            }
        }
    }
}
 