package com.pyromanticgaming.remotemobspawn;

import org.bukkit.command.CommandSender;

public class InfoDisplays {

	static void InfoSection(CommandSender sender) {
		sender.sendMessage("/rms all [mob] [amount] [distance] - Spawns on all players");
		sender.sendMessage("/rms [player] [mob] [amount] [distance] - Spawns on other");
		sender.sendMessage("/rms [mob] [amount] [distance] - Spawns on self");
		sender.sendMessage("/rms glow [on/off] - Toggles glow spawning on or off");
		sender.sendMessage("/rms safespawn [on/off] - Toggles safe spawning on/off");
		sender.sendMessage("If a mob has 2 words in the name use _ like so: ender_dragon");
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

	static void InvalidNumberOfArgs(CommandSender sender) {
		sender.sendMessage("Invalid number of args");
	}

	static void InvalidMob(CommandSender sender) {
		sender.sendMessage("That is not a proper spelling or that is not a mob.");
	}

	static void SafeSpawnFail(CommandSender sender) {
		sender.sendMessage("Mob Spawning has failed - Block in location of spawning");
	}
}
