package net.eca.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class EpicCoreApiConfigurationConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DAMAGE_REPORT;
	public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE_REPORT_RANGE;
	public static final ForgeConfigSpec.ConfigValue<Double> SACRIFICE_MAX_HEALTH_REDUCE;
	public static final ForgeConfigSpec.ConfigValue<String> PRESET_COMMAND;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_PRESET_COMMAND;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXIMUM_ENCHANTMENT_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_BATTLE_SYSTEM;
	public static final ForgeConfigSpec.ConfigValue<Double> STAMINA_RECOVER_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> MANA_RECOVER_VALUE;
	static {
		BUILDER.push("Epic Core API Configuration");
		DAMAGE_REPORT = BUILDER.comment("When true, send detailed information about the entity being injured.为真时，发送实体受伤的详细信息").define("damage_report", true);
		DAMAGE_REPORT_RANGE = BUILDER.comment("Determined the range of damage reporting.这个值决定了伤害报告距离玩家起效的范围").define("damage_report_range", (double) 64);
		SACRIFICE_MAX_HEALTH_REDUCE = BUILDER.comment("Control the maximum health reduction caused by sacrifice enchantment.控制献祭附魔造成的最大生命值减少").define("sacrifice_max_health_reduce", (double) 1);
		PRESET_COMMAND = BUILDER.comment("You can enter the command you want to preset here.你可以在这里输入你想预置的命令。").define("preset_command", "");
		ENABLE_PRESET_COMMAND = BUILDER.comment("When true, the preset command function will be enabled.为真时将会启用预置命令功能。").define("enable_preset_command", true);
		MAXIMUM_ENCHANTMENT_LEVEL = BUILDER.comment("Control maximum enchantment level.控制最大附魔等级").define("maximum_enchantment_level", (double) 5);
		BUILDER.pop();
		BUILDER.push("battle_system_configuration");
		ENABLE_BATTLE_SYSTEM = BUILDER.comment("Enable Epic Core API battle system when true.为真时开启ECA战斗系统  ").define("enable_battle_system", true);
		STAMINA_RECOVER_VALUE = BUILDER.comment("Value of stamina that naturally recovers per second.每秒恢复的精力值").define("stamina_recover_value", (double) 1);
		MANA_RECOVER_VALUE = BUILDER.comment("Value of mana that naturally recovers per second.每秒恢复的魔力值").define("mana_recover_value", (double) 1);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
