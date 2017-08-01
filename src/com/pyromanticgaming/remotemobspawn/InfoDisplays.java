package com.pyromanticgaming.remotemobspawn;

import org.bukkit.command.CommandSender;

public class InfoDisplays {

	static void ComandSyntax(CommandSender sender) {
		sender.sendMessage("/rms all [mob] [amount] [distance] - Spawns on all players");
		sender.sendMessage("/rms [player] [mob] [amount] [distance] - Spawns on other");
		sender.sendMessage("/rms [mob] [amount] [distance] - Spawns on self");
		sender.sendMessage("/rms glow [on/off] - Toggles glow spawning on or off");
		sender.sendMessage("/rms safespawn [on/off] - Toggles safe spawning on/off");
		sender.sendMessage("/rms help - Displays commands");
		sender.sendMessage("If a mob has two words in the name use _ like so: ender_dragon");
		sender.sendMessage("If amount and distance is left blank spawns one mob on player");
	}

	static void MustBePlayer(CommandSender sender) {
		sender.sendMessage("Must specify a user to use from the console.");
	}

	static void InvalidOrNeedPermission(CommandSender sender) {
		sender.sendMessage("RemoteMobSpawn - Command invalid or you lack permission.");
	}

	static void InvalidPlayer(CommandSender sender) {
		sender.sendMessage("Invalid name or user is offline.");
	}

	static void InvalidArgs(CommandSender sender) {
		sender.sendMessage("Invalid Args");
	}

	static void InvalidMob(CommandSender sender) {
		sender.sendMessage("That is not a proper spelling or that is not a mob.");
	}

	static void SafeSpawnFail(CommandSender sender) {
		sender.sendMessage("Mob Spawning has failed - Block in location of spawning");
	}
	
	static void GlowOn(CommandSender sender) {
		sender.sendMessage("Glow Spawning set to On");
	}
	
	static void GlowOff(CommandSender sender) {
		sender.sendMessage("Glow Spawning set to Off");
	}
	
	static void SafeSpawnOn(CommandSender sender) {
		sender.sendMessage("SafeSpawn set to On");
	}
	
	static void SafeSpawnOff(CommandSender sender) {
		sender.sendMessage("SafeSpawn set to Off");
	}
}
