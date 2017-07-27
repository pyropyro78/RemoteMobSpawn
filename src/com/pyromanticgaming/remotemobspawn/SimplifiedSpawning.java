package com.pyromanticgaming.remotemobspawn;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;

public class SimplifiedSpawning {

	
	public static void FindRelativeDirection(int distance, int disx, int disz, double direction) {
		if (direction >= 45 && direction <= 134.9) {
			disx = disx - distance;
		}

		// E
		if (direction >= -134.9 && direction <= -45) {
			disx = disx + distance;
		}

		// N
		if (direction <= -135 || direction >= 135) {
			disz = disz - distance;
		}

		// S
		if (direction >= -44.9 && direction <= 44.9) {
			disz = disz + distance;
		}
	}
	
	public static void SafeSpawning(Location loc, Location newloc, int disx, int disz, CommandSender sender, int amount) {
		Location newloc1;
		if (MainConfig.SafeSpawn) {
			newloc = new Location(loc.getWorld(), loc.getX() + disx,
					loc.getY(), loc.getZ() + disz);
			newloc1 = new Location(loc.getWorld(), loc.getX() + disx,
					loc.getY() + 1, loc.getZ() + disz);
			if (newloc.getBlock().getType().isSolid() || newloc1.getBlock().getType().isSolid()) {
				InfoDisplays.SafeSpawnFail(sender);
				amount = 0;
			}
		} else {
			newloc = new Location(loc.getWorld(), loc.getX() + disx,
					loc.getY(), loc.getZ() + disz);
		}
	}
}
