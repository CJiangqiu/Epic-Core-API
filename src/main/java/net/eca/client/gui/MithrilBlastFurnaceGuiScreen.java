package net.eca.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.eca.world.inventory.MithrilBlastFurnaceGuiMenu;
import net.eca.procedures.MbfArrowShow5Procedure;
import net.eca.procedures.MbfArrowShow4Procedure;
import net.eca.procedures.MbfArrowShow3Procedure;
import net.eca.procedures.MbfArrowShow2Procedure;
import net.eca.procedures.MbfArrowShow1Procedure;
import net.eca.procedures.FuelGuiProcedure;
import net.eca.procedures.FuelGui4Procedure;
import net.eca.procedures.FuelGui3Procedure;
import net.eca.procedures.FuelGui2Procedure;
import net.eca.procedures.FuelGui1Procedure;
import net.eca.procedures.FuelGui0Procedure;
import net.eca.procedures.FuelEnergyGetProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MithrilBlastFurnaceGuiScreen extends AbstractContainerScreen<MithrilBlastFurnaceGuiMenu> {
	private final static HashMap<String, Object> guistate = MithrilBlastFurnaceGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MithrilBlastFurnaceGuiScreen(MithrilBlastFurnaceGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("epic_core_api:textures/screens/mithril_blast_furnace_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 114 && mouseY > topPos + 59 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.literal(FuelEnergyGetProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/arrow.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 32, 32, 32, 32);

		if (MbfArrowShow1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/arrow_1.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 32, 32, 32, 32);
		}
		if (MbfArrowShow2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/arrow_2.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 32, 32, 32, 32);
		}
		if (MbfArrowShow3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/arrow_3.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 32, 32, 32, 32);
		}
		if (MbfArrowShow4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/arrow_4.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 32, 32, 32, 32);
		}
		if (MbfArrowShow5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/arrow_5.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 32, 32, 32, 32);
		}
		if (FuelGuiProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/fuel.png"), this.leftPos + 90, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		}
		if (FuelGui0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/fuel_0.png"), this.leftPos + 90, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		}
		if (FuelGui1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/fuel_1.png"), this.leftPos + 90, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		}
		if (FuelGui2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/fuel_2.png"), this.leftPos + 90, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		}
		if (FuelGui3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/fuel_3.png"), this.leftPos + 90, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		}
		if (FuelGui4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/fuel_4.png"), this.leftPos + 90, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		}
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
	}

	@Override
	public void init() {
		super.init();
	}
}
