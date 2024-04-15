package net.eca.procedures;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.eca.init.EpicCoreApiModEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

@Mod.EventBusSubscriber
public class ExplosionEnchantedRangedWeaponHitProcedure {
    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event != null && event.getEntity() instanceof Projectile projectile) {
            Entity shooter = projectile.getOwner();
            if (shooter instanceof LivingEntity livingEntity) {
                int explosionLevel = Math.max(
                    getExplosionLevel(livingEntity.getMainHandItem()),
                    getExplosionLevel(livingEntity.getOffhandItem())
                );
                if (explosionLevel > 0 && projectile.getCommandSenderWorld() instanceof Level) {
                    Level _level = (Level) projectile.getCommandSenderWorld();
                    if (!_level.isClientSide()) {
                        _level.explode(null, projectile.getX(), projectile.getY(), projectile.getZ(), explosionLevel, Level.ExplosionInteraction.MOB);
                        projectile.remove(Entity.RemovalReason.KILLED);  
                    }
                }
            }
        }
    }

    private static int getExplosionLevel(ItemStack itemStack) {
        if (itemStack.is(ItemTags.create(new ResourceLocation("forge:weapons/ranged_weapon")))) {
            return EnchantmentHelper.getItemEnchantmentLevel(EpicCoreApiModEnchantments.EXPLOSION.get(), itemStack);
        }
        return 0;
    }
}
