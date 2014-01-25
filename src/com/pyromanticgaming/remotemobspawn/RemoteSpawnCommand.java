package com.pyromanticgaming.remotemobspawn;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class RemoteSpawnCommand extends RemoteMobSpawnCommandExecutor {

	public RemoteSpawnCommand(RemoteMobSpawn remotemobspawn) {
		super(remotemobspawn);
	}

	static void remotespawncommand(CommandSender sender, String[] args,
			Player player1) {
		int amount = 1;
		int distance = 0;
		boolean check = false;
		// PLAYER0 MOB1 AMOUNT2 DISTANCE3
		if (args.length == 1) {

			sender.sendMessage("Not enough arguments.");

			return;
		} else if (args.length == 2) {

			check = true;

		} else if (args.length == 3) {
			amount = Integer.parseInt(args[2]);

			check = true;

		} else if (args.length == 4) {
			amount = Integer.parseInt(args[2]);
			distance = Integer.parseInt(args[3]);

			check = true;

		} else {
			sender.sendMessage("Invalid number of args");
			RemoteMobSpawnCommandExecutor.InfoSection(sender);
		}

		if (check == true) {
			Location loc = player1.getLocation();
			int disx = 0;
			int disz = 0;
			double direction = (loc.getYaw());

			// W
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

			if (args[1].equalsIgnoreCase(EntityType.BAT.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.BAT);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.CREEPER.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.CREEPER);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.BLAZE.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.BLAZE);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.ZOMBIE.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.ZOMBIE);
					amount--;
				}
				return;
			} else if (args[1]
					.equalsIgnoreCase(EntityType.PIG_ZOMBIE.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc,
							EntityType.PIG_ZOMBIE);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.CAVE_SPIDER
					.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc,
							EntityType.CAVE_SPIDER);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.CHICKEN.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.CHICKEN);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.COW.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.COW);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.PIG.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.PIG);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.ENDER_DRAGON
					.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc,
							EntityType.ENDER_DRAGON);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.ENDERMAN.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.ENDERMAN);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.GHAST.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.GHAST);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.GIANT.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.GIANT);
					amount--;
				}
				return;
			} else if (args[1]
					.equalsIgnoreCase(EntityType.IRON_GOLEM.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc,
							EntityType.IRON_GOLEM);
					amount--;
				}
				return;
			} else if (args[1]
					.equalsIgnoreCase(EntityType.MAGMA_CUBE.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc,
							EntityType.MAGMA_CUBE);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.OCELOT.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.OCELOT);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.SHEEP.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.SHEEP);
					amount--;
				}
				return;
			} else if (args[1]
					.equalsIgnoreCase(EntityType.SILVERFISH.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc,
							EntityType.SILVERFISH);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.SKELETON.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.SKELETON);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.SLIME.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.SLIME);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.SNOWMAN.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.SNOWMAN);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.SPIDER.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.SPIDER);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.SQUID.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.SQUID);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.VILLAGER.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.VILLAGER);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.WITCH.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.WITCH);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.WITHER.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.WITHER);
					amount--;
				}
				return;
			} else if (args[1].equalsIgnoreCase(EntityType.WOLF.getName())) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.WOLF);
					amount--;
				}
				return;
			}
		}

	}

}
