package net.eca.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.eca.init.EpicCoreApiModAttributes;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration;
import net.eca.EpicCoreApiMod;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class HeavyAttackProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (world.isClientSide()) {
			if (entity instanceof AbstractClientPlayer player) {
				var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("epic_core_api", "player_animation"));
				if (animation != null && animation.isActive()) {
					player.displayClientMessage(Component.literal((Component.translatable("translation.key.skill_is_active").getString())), true);
					return;
				}
				animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("epic_core_api", "heavy_attack"))));
				if (world instanceof Level _level) {
					double x = player.getX();
					double y = player.getY();
					double z = player.getZ();
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "entity.tnt.primed")), SoundSource.VOICE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "entity.tnt.primed")), SoundSource.VOICE, 1, 1, false);
					}
				}
			}
		}
		{
			Vec3 entityPos = entity.position();
			Vec3 lookDirection = entity.getLookAngle();
			double reach = ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getValue();
			Vec3 attackCenter = entityPos.add(lookDirection.scale(reach));
			AABB attackRange = new AABB(attackCenter.x - reach, attackCenter.y - reach, attackCenter.z - reach, attackCenter.x + reach, attackCenter.y + reach, attackCenter.z + reach);
			List<Entity> entitiesInRange = world.getEntitiesOfClass(Entity.class, attackRange, e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(attackCenter))).toList();
			EpicCoreApiMod.queueServerWork(20, () -> {
				for (Entity entityInRange : entitiesInRange) {
					if (entityInRange.equals(entity)) {
						continue;
					}
					if (EpicCoreApiConfigurationConfiguration.ENABLE_HURT_ANIMAL_ENTITY.get() == false) {
						entityInRange.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
								(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 2));
					} else {
						if (!(entityInRange instanceof Animal)) {
							entityInRange.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
									(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 2));
						}
					}
				}
				((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).addPermanentModifier((new AttributeModifier(UUID.randomUUID(), "stamina_reduce", (-20), AttributeModifier.Operation.ADDITION)));
			});
		}
	}
}
