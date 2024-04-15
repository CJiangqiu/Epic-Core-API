
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.eca.EpicCoreApiMod;

public class EpicCoreApiModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, EpicCoreApiMod.MODID);
	public static final RegistryObject<SimpleParticleType> BURNING_PARTICLE = REGISTRY.register("burning_particle", () -> new SimpleParticleType(false));
}
