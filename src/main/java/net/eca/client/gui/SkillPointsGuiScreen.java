package net.eca.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.eca.world.inventory.SkillPointsGuiMenu;
import net.eca.procedures.SkillPointsGetProcedure;
import net.eca.procedures.SkillPointsGetButtonDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SkillPointsGuiScreen extends AbstractContainerScreen<SkillPointsGuiMenu> {
	private final static HashMap<String, Object> guistate = SkillPointsGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_skill_point_button_0;
	ImageButton imagebutton_skill_point_button_01;
	ImageButton imagebutton_skill_point_button_02;
	ImageButton imagebutton_skill_point_button_03;
	ImageButton imagebutton_skill_point_button_04;
	ImageButton imagebutton_skill_point_button_05;
	ImageButton imagebutton_skill_point_button_06;
	ImageButton imagebutton_skill_point_button_08;
	ImageButton imagebutton_skill_point_button_09;
	ImageButton imagebutton_skill_point_button_010;
	ImageButton imagebutton_skill_point_button_011;
	ImageButton imagebutton_skill_point_button_012;
	ImageButton imagebutton_skill_point_button_013;
	ImageButton imagebutton_skill_point_button_014;
	ImageButton imagebutton_skill_point_button_015;
	ImageButton imagebutton_skill_points_get;

	public SkillPointsGuiScreen(SkillPointsGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 424;
		this.imageHeight = 238;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 34 && mouseY > topPos + 124 && mouseY < topPos + 148)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_charge_attack"), mouseX, mouseY);
		if (mouseX > leftPos + 32 && mouseX < leftPos + 56 && mouseY > topPos + 106 && mouseY < topPos + 130)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_dash_attack"), mouseX, mouseY);
		if (mouseX > leftPos + 12 && mouseX < leftPos + 36 && mouseY > topPos + 88 && mouseY < topPos + 112)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_shield_smite"), mouseX, mouseY);
		if (mouseX > leftPos + 54 && mouseX < leftPos + 78 && mouseY > topPos + 126 && mouseY < topPos + 150)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_dual_wield_combo"), mouseX, mouseY);
		if (mouseX > leftPos + 58 && mouseX < leftPos + 82 && mouseY > topPos + 75 && mouseY < topPos + 99)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_sword_qi"), mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 108 && mouseY < topPos + 132)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_mana_skin"), mouseX, mouseY);
		if (mouseX > leftPos + 169 && mouseX < leftPos + 193 && mouseY > topPos + 131 && mouseY < topPos + 155)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_mana_spring"), mouseX, mouseY);
		if (mouseX > leftPos + 188 && mouseX < leftPos + 212 && mouseY > topPos + 78 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_double_souls"), mouseX, mouseY);
		if (mouseX > leftPos + 216 && mouseX < leftPos + 240 && mouseY > topPos + 103 && mouseY < topPos + 127)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_elemental_resonance"), mouseX, mouseY);
		if (mouseX > leftPos + 217 && mouseX < leftPos + 241 && mouseY > topPos + 77 && mouseY < topPos + 101)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_proficient_in_godly_spells"), mouseX, mouseY);
		if (mouseX > leftPos + 338 && mouseX < leftPos + 362 && mouseY > topPos + 131 && mouseY < topPos + 155)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_light_footsteps"), mouseX, mouseY);
		if (mouseX > leftPos + 367 && mouseX < leftPos + 391 && mouseY > topPos + 105 && mouseY < topPos + 129)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_hidden_in_the_shadow"), mouseX, mouseY);
		if (mouseX > leftPos + 336 && mouseX < leftPos + 360 && mouseY > topPos + 103 && mouseY < topPos + 127)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_throwing_knife"), mouseX, mouseY);
		if (mouseX > leftPos + 351 && mouseX < leftPos + 375 && mouseY > topPos + 80 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_master_of_ranged_weapons"), mouseX, mouseY);
		if (mouseX > leftPos + 381 && mouseX < leftPos + 405 && mouseY > topPos + 75 && mouseY < topPos + 99)
			guiGraphics.renderTooltip(font, Component.translatable("gui.epic_core_api.skill_points_gui.tooltip_knell"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/skill_points_gui.png"), this.leftPos + -46, this.topPos + -90, 0, 0, 512, 362, 512, 362);

		guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/warrior_constellation.png"), this.leftPos + 12, this.topPos + 75, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/caster_constellation.png"), this.leftPos + 171, this.topPos + 82, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/ranger_constellation.png"), this.leftPos + 341, this.topPos + 81, 0, 0, 64, 64, 64, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				SkillPointsGetProcedure.execute(entity), 170, 223, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.epic_core_api.skill_points_gui.label_warrior_constellation"), 4, 143, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.epic_core_api.skill_points_gui.label_caster_constellation"), 163, 143, -6749953, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.epic_core_api.skill_points_gui.label_ranger_constellation"), 329, 142, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_skill_point_button_0 = new ImageButton(this.leftPos + 21, this.topPos + 129, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_0.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_0", imagebutton_skill_point_button_0);
		this.addRenderableWidget(imagebutton_skill_point_button_0);
		imagebutton_skill_point_button_01 = new ImageButton(this.leftPos + 37, this.topPos + 113, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_01.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_01", imagebutton_skill_point_button_01);
		this.addRenderableWidget(imagebutton_skill_point_button_01);
		imagebutton_skill_point_button_02 = new ImageButton(this.leftPos + 22, this.topPos + 99, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_02.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_02", imagebutton_skill_point_button_02);
		this.addRenderableWidget(imagebutton_skill_point_button_02);
		imagebutton_skill_point_button_03 = new ImageButton(this.leftPos + 54, this.topPos + 127, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_03.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_03", imagebutton_skill_point_button_03);
		this.addRenderableWidget(imagebutton_skill_point_button_03);
		imagebutton_skill_point_button_04 = new ImageButton(this.leftPos + 64, this.topPos + 85, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_04.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_04", imagebutton_skill_point_button_04);
		this.addRenderableWidget(imagebutton_skill_point_button_04);
		imagebutton_skill_point_button_05 = new ImageButton(this.leftPos + 179, this.topPos + 133, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_05.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_05", imagebutton_skill_point_button_05);
		this.addRenderableWidget(imagebutton_skill_point_button_05);
		imagebutton_skill_point_button_06 = new ImageButton(this.leftPos + 193, this.topPos + 119, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_06.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_06", imagebutton_skill_point_button_06);
		this.addRenderableWidget(imagebutton_skill_point_button_06);
		imagebutton_skill_point_button_08 = new ImageButton(this.leftPos + 203, this.topPos + 90, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_08.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_08", imagebutton_skill_point_button_08);
		this.addRenderableWidget(imagebutton_skill_point_button_08);
		imagebutton_skill_point_button_09 = new ImageButton(this.leftPos + 219, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_09.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_09", imagebutton_skill_point_button_09);
		this.addRenderableWidget(imagebutton_skill_point_button_09);
		imagebutton_skill_point_button_010 = new ImageButton(this.leftPos + 222, this.topPos + 87, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_010.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_010", imagebutton_skill_point_button_010);
		this.addRenderableWidget(imagebutton_skill_point_button_010);
		imagebutton_skill_point_button_011 = new ImageButton(this.leftPos + 348, this.topPos + 133, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_011.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_011", imagebutton_skill_point_button_011);
		this.addRenderableWidget(imagebutton_skill_point_button_011);
		imagebutton_skill_point_button_012 = new ImageButton(this.leftPos + 352, this.topPos + 111, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_012.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_012", imagebutton_skill_point_button_012);
		this.addRenderableWidget(imagebutton_skill_point_button_012);
		imagebutton_skill_point_button_013 = new ImageButton(this.leftPos + 376, this.topPos + 115, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_013.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_013", imagebutton_skill_point_button_013);
		this.addRenderableWidget(imagebutton_skill_point_button_013);
		imagebutton_skill_point_button_014 = new ImageButton(this.leftPos + 364, this.topPos + 92, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_014.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_014", imagebutton_skill_point_button_014);
		this.addRenderableWidget(imagebutton_skill_point_button_014);
		imagebutton_skill_point_button_015 = new ImageButton(this.leftPos + 386, this.topPos + 84, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_point_button_015.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_skill_point_button_015", imagebutton_skill_point_button_015);
		this.addRenderableWidget(imagebutton_skill_point_button_015);
		imagebutton_skill_points_get = new ImageButton(this.leftPos + 259, this.topPos + 217, 16, 16, 0, 0, 16, new ResourceLocation("epic_core_api:textures/screens/atlas/imagebutton_skill_points_get.png"), 16, 32, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (SkillPointsGetButtonDisplayProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_skill_points_get", imagebutton_skill_points_get);
		this.addRenderableWidget(imagebutton_skill_points_get);
	}
}
