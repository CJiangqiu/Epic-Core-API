package net.eca.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.player.AbstractClientPlayer;

import net.eca.init.EpicCoreApiModAttributes;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class ShieldSmiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/shield")))) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("epic_core_api", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("epic_core_api", "Biped.animation.shield_smite"))));
					}
				}
			}
			((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).addPermanentModifier((new AttributeModifier(UUID.randomUUID(), "shield_smite", (-10), AttributeModifier.Operation.ADDITION)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center.add(-1.5, 0, -1.5), _center.add(1.5, 2, 1.5)), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
							(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/shield")))) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("epic_core_api", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("epic_core_api", "Biped.animation.shield_smite_0"))));
					}
				}
			}
			((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).addPermanentModifier((new AttributeModifier(UUID.randomUUID(), "shield_smite", (-10), AttributeModifier.Operation.ADDITION)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center.add(-1.5, 0, -1.5), _center.add(1.5, 2, 1.5)), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
							(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
				}
			}
		}
	}
}

