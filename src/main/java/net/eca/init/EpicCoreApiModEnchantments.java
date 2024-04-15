
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.eca.enchantment.SunderArmorEnchantment;
import net.eca.enchantment.SoulProtectionEnchantment;
import net.eca.enchantment.SacrificeEnchantment;
import net.eca.enchantment.ReflectionEnchantment;
import net.eca.enchantment.PoisoningEnchantment;
import net.eca.enchantment.PhantomEnchantment;
import net.eca.enchantment.ExplosionEnchantment;
import net.eca.enchantment.DivineWrathEnchantment;
import net.eca.enchantment.DivineBlessingEnchantment;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EpicCoreApiMod.MODID);
	public static final RegistryObject<Enchantment> SACRIFICE = REGISTRY.register("sacrifice", () -> new SacrificeEnchantment());
	public static final RegistryObject<Enchantment> POISONING = REGISTRY.register("poisoning", () -> new PoisoningEnchantment());
	public static final RegistryObject<Enchantment> DIVINE_WRATH = REGISTRY.register("divine_wrath", () -> new DivineWrathEnchantment());
	public static final RegistryObject<Enchantment> SUNDER_ARMOR = REGISTRY.register("sunder_armor", () -> new SunderArmorEnchantment());
	public static final RegistryObject<Enchantment> SOUL_PROTECTION = REGISTRY.register("soul_protection", () -> new SoulProtectionEnchantment());
	public static final RegistryObject<Enchantment> PHANTOM = REGISTRY.register("phantom", () -> new PhantomEnchantment());
	public static final RegistryObject<Enchantment> DIVINE_BLESSING = REGISTRY.register("divine_blessing", () -> new DivineBlessingEnchantment());
	public static final RegistryObject<Enchantment> REFLECTION = REGISTRY.register("reflection", () -> new ReflectionEnchantment());
	public static final RegistryObject<Enchantment> EXPLOSION = REGISTRY.register("explosion", () -> new ExplosionEnchantment());
}
