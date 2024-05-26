
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.eca.EpicCoreApiMod;

public class EpicCoreApiModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EpicCoreApiMod.MODID);
	public static final RegistryObject<SoundEvent> SKILL_POINT_USE = REGISTRY.register("skill_point_use", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("epic_core_api", "skill_point_use")));
	public static final RegistryObject<SoundEvent> CHARGE_ATTACK = REGISTRY.register("charge_attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("epic_core_api", "charge_attack")));
}
