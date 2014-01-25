package com.pyromanticgaming.remotemobspawn;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class RemoteMobSpawnCommandExecutor implements CommandExecutor {

	public static Set<String> playerList = new HashSet<String>();

	private RemoteMobSpawn remotemobspawn;

	public RemoteMobSpawnCommandExecutor(RemoteMobSpawn remotemobspawn) {
		this.remotemobspawn = remotemobspawn;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("rms")) {

			boolean canSpawn = sender
					.hasPermission("RemoteMobSpawn.spawn.self")
					|| sender.isOp();
			boolean canRemoteSpawn = sender
					.hasPermission("RemoteMobSpawn.spawn.other")
					|| sender.isOp();
			boolean canStar = sender.hasPermission("RemoteMobSpawn.*")
					|| sender.isOp();
			if (!canStar && !sender.isOp()) {
				sender.sendMessage("RemoteMobSpawn - You do not have permission for that.");
				return true;
			} else {
				if (args.length > 0) {
					if (canRemoteSpawn) {
						playerList.clear();
						for (Player otherPlayer : remotemobspawn.getServer()
								.getOnlinePlayers()) {
							// Add online users to the playerList HashMap
							playerList.add(otherPlayer.getName());
						}
						if (playerList.contains(args[0])) {
							// PLAYER0 MOB1 AMOUNT2 DISTANCE3
							Player player1 = Bukkit.getPlayer(args[0]);
							if (args[0].equals(player1.getName())
									&& canRemoteSpawn) {
								if (args[0].equals(sender.getName())
										&& canSpawn) {
									RemoteSpawnCommand.remotespawncommand(
											sender, args, player1);
									return true;
								} else if (args[0].equals(sender.getName())
										&& !canSpawn) {
									sender.sendMessage("RemoteMobSpawn - You do not have permission for that.");
									return true;
								} else if (!args[0].equals(sender.getName())) {
									RemoteSpawnCommand.remotespawncommand(
											sender, args, player1);
									return true;
								}
							} else {
								sender.sendMessage("Invalid name or user is offline.");
								return true;
							}
						}
					} else {
						sender.sendMessage("RemoteMobSpawn - You do not have permission for that.");
						return true;
					}
					if (canSpawn) {
						for (EntityType c : EntityType.values()) {
							// MOB0 AMOUNT1 DISTANCE2
							if (args[0].equalsIgnoreCase(c.name())) {
								if (sender instanceof Player) {
									SpawnCommand.spawncommand(sender, args);
									return true;
								} else {
									sender.sendMessage("Must specify a user to use from the console.");
									InfoSection(sender);
									return true;
								}
							}
						}
					} else {
						sender.sendMessage("RemoteMobSpawn - You do not have permission for that.");
						return true;
					}
				}
			}
		}

		return false;
	}
	
	static void SafeSpawn() {
		
	}

	static void InfoSection(CommandSender sender) {
		sender.sendMessage("/rms [player] [mob] [amount] [distance] - Spawns on other");
		sender.sendMessage("/rms [mob] [amount] [distance] - Spawns on self");
	}

}
