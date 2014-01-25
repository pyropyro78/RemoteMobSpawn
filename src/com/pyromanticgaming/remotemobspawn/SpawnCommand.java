package com.pyromanticgaming.remotemobspawn;

/*
*Copyright (c) <2013>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
*
*    Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
*    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnCommand extends RemoteMobSpawnCommandExecutor {

	public SpawnCommand(RemoteMobSpawn remotemobspawn) {
		super(remotemobspawn);

	}

	static void spawncommand(CommandSender sender, String[] args) {

		int amount = 1;
		int distance = 0;

		if (args.length == 2) {
			amount = Integer.parseInt(args[1]);
		} else if (args.length == 3) {
			amount = Integer.parseInt(args[1]);
			distance = Integer.parseInt(args[2]);
		} else {
			sender.sendMessage("Invalid number of args");
			RemoteMobSpawnCommandExecutor.InfoSection(sender);
		}

		// MOB0 AMOUNT1 DISTANCE2
		Player player = (Player) sender;
		Location loc = player.getLocation();
		int disx = 0;
		int disz = 0;
		double direction = (loc.getYaw());

		// W
		if (direction >= 45 && direction <= 134.9) {
			disx = disx - distance;
		}

		// E
		else if (direction >= -134.9 && direction <= -45) {
			disx = disx + distance;
		}

		// N
		else if (direction <= -135 || direction >= 135) {
			disz = disz - distance;
		}

		// S
		else if (direction >= -44.9 && direction <= 44.9) {
			disz = disz + distance;
		}

		Location newloc, newloc1;

		if (RemoteMobSpawn.SafeSpawn) {
		newloc = new Location(loc.getWorld(), loc.getX() + disx,
				loc.getY(), loc.getZ() + disz);
		newloc1 = new Location(loc.getWorld(), loc.getX() + disx,
				loc.getY() + 1, loc.getZ() + disz);
		if (newloc.getBlock().getType().isSolid() || newloc1.getBlock().getType().isSolid()) {
			sender.sendMessage("Mob Spawning has failed - Block in location of spawning");
			amount = 0;
		}
		} else {
			newloc = new Location(loc.getWorld(), loc.getX() + disx,
					loc.getY(), loc.getZ() + disz);
		}

		if (args[0].equalsIgnoreCase(EntityType.BAT.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.BAT);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.CREEPER.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.CREEPER);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.BLAZE.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.BLAZE);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.ZOMBIE.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.ZOMBIE);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.PIG_ZOMBIE.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.PIG_ZOMBIE);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.CAVE_SPIDER.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.CAVE_SPIDER);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.CHICKEN.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.CHICKEN);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.COW.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.COW);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.PIG.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.PIG);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.ENDER_DRAGON.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.ENDER_DRAGON);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.ENDERMAN.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.ENDERMAN);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.GHAST.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.GHAST);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.GIANT.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.GIANT);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.IRON_GOLEM.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.IRON_GOLEM);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.MAGMA_CUBE.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.MAGMA_CUBE);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.OCELOT.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.OCELOT);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SHEEP.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SHEEP);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SILVERFISH.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SILVERFISH);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SKELETON.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SKELETON);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SLIME.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SLIME);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SNOWMAN.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SNOWMAN);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SPIDER.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SPIDER);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.SQUID.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.SQUID);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.VILLAGER.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.VILLAGER);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.WITCH.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.WITCH);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.WITHER.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.WITHER);
				amount--;
			}
			return;
		} else if (args[0].equalsIgnoreCase(EntityType.WOLF.getName())) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.WOLF);
				amount--;
			}
			return;
		}

	}

}
