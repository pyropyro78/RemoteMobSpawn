package com.pyromanticgaming.remotemobspawn;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SimplifiedSpawning {


	public static void FindRelativeDirection(int distance, String uppername, int amount, Player player1, CommandSender sender) {
		int disx = 0;
		int disz = 0;
		Location loc = player1.getLocation();
		double direction = (loc.getYaw());
		
		// W
		if (direction >= 225 && direction <= 314.9) {
			disx = disx + distance;
		}

		// E
		if (direction >= 45 && direction <= 134.9) {
			disx = disx - distance;
		}

		// N
		if (direction >= 135 && direction <= 224.9) {
			disz = disz - distance;
		}

		// S
		if (direction >= 315 || direction <= 44.9) {
			disz = disz + distance;
		}
		sender.sendMessage(" " + distance + " " + disx + " " + disz);
		SafeSpawning(loc, disx, disz, sender, amount, player1, uppername);
	}

	private static void SafeSpawning(Location loc, int disx, int disz, CommandSender sender, int amount, Player player1, String uppername) {
		Location newloc = new Location(loc.getWorld(), loc.getX() + disx,loc.getY(), loc.getZ() + disz);
		Location newloc1;
		if (MainConfig.SafeSpawn) {
			newloc1 = new Location(loc.getWorld(), loc.getX() + disx, loc.getY() + 1, loc.getZ() + disz);
			if (newloc.getBlock().getType().isSolid() || newloc1.getBlock().getType().isSolid()) {
				InfoDisplays.SafeSpawnFail(sender);
				amount = 0;
			} else {
				Spawn(uppername, player1, newloc, amount, sender);
			}
		} else {
			Spawn(uppername, player1, newloc, amount, sender);
		}
	}

	public static void Spawn(String uppername, Player player1, Location newloc, int amount, CommandSender sender) {
		while (amount > 0) {
			player1.getWorld().spawnEntity(newloc, EntityType.valueOf(uppername)).setGlowing(MainConfig.Glow);
			amount--;
		}
		return;
	}
}
