
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.eca.world.inventory.SkillPointsGuiMenu;
import net.eca.world.inventory.MithrilBlastFurnaceGuiMenu;
import net.eca.world.inventory.EditStaminaManaOverlayMenu;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EpicCoreApiMod.MODID);
	public static final RegistryObject<MenuType<MithrilBlastFurnaceGuiMenu>> MITHRIL_BLAST_FURNACE_GUI = REGISTRY.register("mithril_blast_furnace_gui", () -> IForgeMenuType.create(MithrilBlastFurnaceGuiMenu::new));
	public static final RegistryObject<MenuType<EditStaminaManaOverlayMenu>> EDIT_STAMINA_MANA_OVERLAY = REGISTRY.register("edit_stamina_mana_overlay", () -> IForgeMenuType.create(EditStaminaManaOverlayMenu::new));
	public static final RegistryObject<MenuType<SkillPointsGuiMenu>> SKILL_POINTS_GUI = REGISTRY.register("skill_points_gui", () -> IForgeMenuType.create(SkillPointsGuiMenu::new));
}
