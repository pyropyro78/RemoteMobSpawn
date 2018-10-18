package com.pyromanticgaming.remotemobspawn;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnCommand {

	@SuppressWarnings("unused")
	private static RemoteMobSpawn plugin;

	public SpawnCommand(RemoteMobSpawn instance) {
		plugin = instance;
	}

	static void spawncommand(CommandSender sender, String[] args) {

		int amount = 1;
		int distance = 0;
		boolean check = false, SetGlow = false;

		if (args.length == 1) {
			if(MainConfig.Glow) {
				SetGlow = true;
			}
			check = true;
		} else
			if (args.length == 2) {
				try {
					amount = Integer.parseInt(args[1]);
				} catch (Exception e) {
					InfoDisplays.InvalidAmount(sender);
				}
				if(MainConfig.Glow) {
					SetGlow = true;
				}
				check = true;
			} else
				if (args.length == 3) {
					try {
						amount = Integer.parseInt(args[1]);
					} catch (Exception e) {
						InfoDisplays.InvalidAmount(sender);
					}
					try {
						distance = Integer.parseInt(args[2]);
					} catch (Exception e) {
						InfoDisplays.InvalidDistance(sender);
					}
					if(MainConfig.Glow) {
						SetGlow = true;
					}
					check = true;
				} else
					if (RemoteMobSpawn.NotLegacy && args.length == 4 && (sender.hasPermission("RemoteMobSpawn.spawn.glow") || sender.isOp())) {
						try {
							if (Integer.parseInt(args[1]) >= 0) {
								amount = Integer.parseInt(args[1]);
							} else {
								InfoDisplays.InvalidAmount(sender);
							}
						} catch (Exception e) {
							InfoDisplays.InvalidAmount(sender);
						}
						try {
							if (Integer.parseInt(args[2]) >= 0) {
								distance = Integer.parseInt(args[2]);
							} else {
								InfoDisplays.InvalidDistance(sender);
							}
						} catch (Exception e) {
							InfoDisplays.InvalidDistance(sender);
						}
						try {
							if (args[3].equalsIgnoreCase("true") || args[3].equalsIgnoreCase("false")) {
								SetGlow = Boolean.parseBoolean(args[3]);
							} else {
								InfoDisplays.InvalidGlow(sender);
								if(MainConfig.Glow) {
									SetGlow = true;
								}
							}
						} catch (Exception e) {
							InfoDisplays.InvalidGlow(sender);
							if(MainConfig.Glow) {
								SetGlow = true;
							}
						}
						check = true;

					} else
						if (RemoteMobSpawn.NotLegacy && args.length == 4 && !(sender.hasPermission("RemoteMobSpawn.spawn.glow") || sender.isOp())) {
							InfoDisplays.InvalidGlowPermission(sender);

						} else
							if (!RemoteMobSpawn.NotLegacy && args.length == 4) {
								InfoDisplays.LegacyWarning(sender);

							} else {
								InfoDisplays.InvalidArgs(sender);
								InfoDisplays.ComandSyntax(sender);
							}

		if (check == true) {
			// MOB0 AMOUNT1 DISTANCE2
			Player player = (Player) sender;
			String uppername = args[0].toUpperCase();
			if(EntityType.valueOf(uppername).isSpawnable()) {
				SimplifiedSpawning.FindRelativeDirection(distance, uppername, amount, player, sender, SetGlow);
			} else
				if(!EntityType.valueOf(uppername).isSpawnable()) {
					InfoDisplays.InvalidMob(sender);
				}
		}
	}

}
