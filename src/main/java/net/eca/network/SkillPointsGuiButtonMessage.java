
package net.eca.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.eca.world.inventory.SkillPointsGuiMenu;
import net.eca.procedures.ThrowingKnifeUnlockProcedure;
import net.eca.procedures.SwordQiUnlockProcedure;
import net.eca.procedures.SkillPointsButtonPressProcedure;
import net.eca.procedures.ShieldSmiteUnlockProcedure;
import net.eca.procedures.ProficientInGodlySpellsUnlockProcedure;
import net.eca.procedures.MasterOfRangedWeaponsUnlockProcedure;
import net.eca.procedures.ManaSpringUnlockProcedure;
import net.eca.procedures.ManaSkinUnlockProcedure;
import net.eca.procedures.LightFootstepsUnlockProcedure;
import net.eca.procedures.KnellUnlockProcedure;
import net.eca.procedures.HiddenInTheShadowUnlockProcedure;
import net.eca.procedures.HeavyAttackUnlockProcedure;
import net.eca.procedures.ElementalResonanceUnlockProcedure;
import net.eca.procedures.DualWieldComboUnlockProcedure;
import net.eca.procedures.DoubleSoulsUnlockProcedure;
import net.eca.procedures.ChargeAttackUnlockProcedure;
import net.eca.EpicCoreApiMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillPointsGuiButtonMessage {
	private final int buttonID, x, y, z;

	public SkillPointsGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SkillPointsGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SkillPointsGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SkillPointsGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SkillPointsGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ChargeAttackUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			HeavyAttackUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ShieldSmiteUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			DualWieldComboUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwordQiUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ManaSpringUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ManaSkinUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			DoubleSoulsUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ElementalResonanceUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ProficientInGodlySpellsUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			LightFootstepsUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			ThrowingKnifeUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			HiddenInTheShadowUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			MasterOfRangedWeaponsUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			KnellUnlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			SkillPointsButtonPressProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EpicCoreApiMod.addNetworkMessage(SkillPointsGuiButtonMessage.class, SkillPointsGuiButtonMessage::buffer, SkillPointsGuiButtonMessage::new, SkillPointsGuiButtonMessage::handler);
	}
}
