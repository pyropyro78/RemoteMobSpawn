package com.pyromanticgaming.remotemobspawn;

/*
*Copyright (c) <2013-2016>, <pyropyro78>, <pyropyro78@gmail.com>
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
			String uppername = args[1].toUpperCase();
			if(EntityType.valueOf(uppername).isSpawnable()) {
				while (amount > 0) {
					player1.getWorld().spawnEntity(newloc, EntityType.valueOf(uppername)).setGlowing(RemoteMobSpawn.Glow);
					amount--;
				}
				return;
			}
			else if(!EntityType.valueOf(uppername).isSpawnable()) {
				sender.sendMessage("That is not a proper spelling or that is not a mob.");
			}
		}

	}

}
