package net.eca.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.eca.world.inventory.EditStaminaManaOverlayMenu;
import net.eca.procedures.StaminaTextShowProcedure;
import net.eca.client.screens.StaminaManaOverlayOverlay;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EditStaminaManaOverlayScreen extends AbstractContainerScreen<EditStaminaManaOverlayMenu> {
    private final static HashMap<String, Object> guistate = EditStaminaManaOverlayMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    public static int staminaIconX = 0; 
    public static int staminaIconY = 0; 
    public static int manaIconX = 0; 
    public static int manaIconY = 0; 

    // Add new fields to track the dragging state and the initial click position
    private boolean isDraggingStamina = false;
    private boolean isDraggingMana = false;
    private int initialClickX = 0;
    private int initialClickY = 0;

    public EditStaminaManaOverlayScreen(EditStaminaManaOverlayMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;

        // Get the positions from the overlay and set them as the positions of the GUI components
        this.staminaIconX = StaminaManaOverlayOverlay.staminaIconX;
        this.staminaIconY = StaminaManaOverlayOverlay.staminaIconY;
        this.manaIconX = StaminaManaOverlayOverlay.manaIconX;
        this.manaIconY = StaminaManaOverlayOverlay.manaIconY;
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
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/stamina.png"), this.leftPos + staminaIconX, this.topPos + staminaIconY, 0, 0, 16, 16, 16, 16);

        guiGraphics.blit(new ResourceLocation("epic_core_api:textures/screens/mana.png"), this.leftPos + manaIconX, this.topPos + manaIconY, 0, 0, 16, 16, 16, 16);

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

                StaminaTextShowProcedure.execute(entity), staminaIconX, staminaIconY, -12829636, false);
        guiGraphics.drawString(this.font,

                StaminaTextShowProcedure.execute(entity), manaIconX, manaIconY, -12829636, false);
    }

    @Override
    public void onClose() {
        super.onClose();
        
        // Save the new positions to StaminaManaOverlayOverlay
        StaminaManaOverlayOverlay.staminaIconX = this.staminaIconX;
        StaminaManaOverlayOverlay.staminaIconY = this.staminaIconY;
        StaminaManaOverlayOverlay.manaIconX = this.manaIconX;
        StaminaManaOverlayOverlay.manaIconY = this.manaIconY;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) { // Left mouse button
            // Check if the mouse is over the stamina icon
            if (mouseX >= this.leftPos + staminaIconX && mouseX <= this.leftPos + staminaIconX + 16
                && mouseY >= this.topPos + staminaIconY && mouseY <= this.topPos + staminaIconY + 16) {
                this.isDraggingStamina = true;
            }
            // Check if the mouse is over the mana icon
            else if (mouseX >= this.leftPos + manaIconX && mouseX <= this.leftPos + manaIconX + 16
                && mouseY >= this.topPos + manaIconY && mouseY <= this.topPos + manaIconY + 16) {
                this.isDraggingMana = true;
            }
            this.initialClickX = (int) mouseX;
            this.initialClickY = (int) mouseY;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) { // Left mouse button
            this.isDraggingStamina = false;
            this.isDraggingMana = false;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        if (this.isDraggingStamina) {
            this.staminaIconX += mouseX - this.initialClickX;
            this.staminaIconY += mouseY - this.initialClickY;
            this.initialClickX = (int) mouseX;
            this.initialClickY = (int) mouseY;
        }
        else if (this.isDraggingMana) {
            this.manaIconX += mouseX - this.initialClickX;
            this.manaIconY += mouseY - this.initialClickY;
            this.initialClickX = (int) mouseX;
            this.initialClickY = (int) mouseY;
        }
        super.mouseMoved(mouseX, mouseY);
    }
}
