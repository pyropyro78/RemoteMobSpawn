package com.pyromanticgaming.remotemobspawn;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SimplifiedSpawning {

	
	public static void FindRelativeDirection(int distance, int disx, int disz, double direction) {
		// W
		if (direction >= 45 && direction <= 134.9) {
			disx = disx - distance;
		}

		// E
		if (direction >= 224.9 && direction <= 314.9) {
			disx = disx + distance;
		}

		// N
		if (direction <= 135 || direction >= 225) {
			disz = disz - distance;
		}

		// S
		if (direction >= 315 || direction <= 44.9) {
			disz = disz + distance;
		}
	}
	
	public static void SafeSpawning(Location loc, Location newloc, int disx, int disz, CommandSender sender, int amount) {
		Location newloc1;
		if (MainConfig.SafeSpawn) {
			newloc1 = new Location(loc.getWorld(), loc.getX() + disx, loc.getY() + 1, loc.getZ() + disz);
			if (newloc.getBlock().getType().isSolid() || newloc1.getBlock().getType().isSolid()) {
				InfoDisplays.SafeSpawnFail(sender);
				amount = 0;
			}
		} else {
			newloc = new Location(loc.getWorld(), loc.getX() + disx,
					loc.getY(), loc.getZ() + disz);
		}
	}
	
	public static void Spawn(String uppername, Player player1, Location newloc, int amount, CommandSender sender) {
		if(EntityType.valueOf(uppername).isSpawnable()) {
			while (amount > 0) {
				player1.getWorld().spawnEntity(newloc, EntityType.valueOf(uppername)).setGlowing(MainConfig.Glow);
				amount--;
			}
			return;
		}
		else if(!EntityType.valueOf(uppername).isSpawnable()) {
			InfoDisplays.InvalidMob(sender);
		}
	}
}
