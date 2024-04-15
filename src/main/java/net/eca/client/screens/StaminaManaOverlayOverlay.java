package net.eca.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.eca.procedures.StaminaTextShowProcedure;
import net.eca.procedures.OverlayShowProcedure;
import net.eca.procedures.ManaTextShowProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class StaminaManaOverlayOverlay {
    public static int staminaIconX = -164; 
    public static int staminaIconY = 84; 
    public static int staminaTextX = -147; 
    public static int staminaTextY = 89; 

    public static int manaIconX = 91; 
    public static int manaIconY = 84; 
    public static int manaTextX = 107; 
    public static int manaTextY = 89; 

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();
        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        Player entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        if (OverlayShowProcedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("epic_core_api:textures/screens/stamina.png"), w / 2 + staminaIconX, h / 2 + staminaIconY, 0, 0, 16, 16, 16, 16);

            event.getGuiGraphics().blit(new ResourceLocation("epic_core_api:textures/screens/mana.png"), w / 2 + manaIconX, h / 2 + manaIconY, 0, 0, 16, 16, 16, 16);

            event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                    StaminaTextShowProcedure.execute(entity), w / 2 + staminaTextX, h / 2 + staminaTextY, -13369549, false);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                    ManaTextShowProcedure.execute(entity), w / 2 + manaTextX, h / 2 + manaTextY, -16711681, false);
        }
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }
}

