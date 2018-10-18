package com.pyromanticgaming.remotemobspawn;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MainCommandHandler implements CommandExecutor {

	public MainCommandHandler(RemoteMobSpawn remotemobspawn) {
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("rms")) {

			boolean canSpawn = sender.hasPermission("RemoteMobSpawn.spawn.self")
					|| sender.isOp();
			boolean canRemoteSpawn = sender.hasPermission("RemoteMobSpawn.spawn.other")
					|| sender.isOp();
			boolean canAll = sender.hasPermission("RemoteMobSpawn.spawn.all")
					|| sender.isOp();
			boolean canModify = sender.hasPermission("RemoteMobSpawn.modify")
					|| sender.isOp();

			boolean checkformob = false;
			try{
				if(EntityType.valueOf(args[0].toUpperCase()).isSpawnable()) {
					checkformob = true;
				}
			} catch (Exception e) {

			}
			
			if (canRemoteSpawn && !args[0].equalsIgnoreCase("all") && (Bukkit.getPlayer(args[0]) instanceof Player)) {
				// PLAYER0 MOB1 AMOUNT2 DISTANCE3
				Player player1 = Bukkit.getPlayerExact(args[0]);
				if (args[0].equals(player1.getName())) {
					if (args[0].equals(sender.getName())
							&& canSpawn) {
						RemoteSpawnCommand.remotespawncommand(
								sender, args, player1);
						return true;
					} else if (args[0].equals(sender.getName())
							&& !canSpawn) {
						InfoDisplays.InvalidOrNeedPermission(sender);
						return true;
					} else if (!args[0].equals(sender.getName())) {
						RemoteSpawnCommand.remotespawncommand(
								sender, args, player1);
						return true;
					}
				}else {
					InfoDisplays.InvalidPlayer(sender);
					return true;
				}
			} else
				if (canAll && args[0].equalsIgnoreCase("all")) {
					AllSpawnCommand.allspawncommand(sender, args);
					return true;
				} else
					if (canModify && (args.length == 2) && args[0].equalsIgnoreCase("glow")) {
						MainConfig.SetGlow(args, sender);
						return true;
					} else
						if (canModify && (args.length == 2) && args[0].equalsIgnoreCase("safespawn")) {
							MainConfig.SafeSpawn(args, sender);
							return true;
						} else
							if (canSpawn && checkformob) {
								// MOB0 AMOUNT1 DISTANCE2
									if (sender instanceof Player) {
										SpawnCommand.spawncommand(sender, args);
										return true;
									} else {
										InfoDisplays.MustBePlayer(sender);
										InfoDisplays.ComandSyntax(sender);
										return true;
									}
							} else
								if ((args.length == 1) && args[0].equalsIgnoreCase("help")) {
									InfoDisplays.ComandSyntax(sender);
									return true;
								} else{
									InfoDisplays.InvalidOrNeedPermission(sender);
									InfoDisplays.ComandSyntax(sender);
									return true;
								}
		}

		return false;
	}

}
