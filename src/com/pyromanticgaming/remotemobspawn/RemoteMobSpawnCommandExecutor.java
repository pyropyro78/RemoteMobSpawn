package com.pyromanticgaming.remotemobspawn;

/*
*Copyright (c) <2013-2016>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

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

	protected static RemoteMobSpawn remotemobspawn;

	public RemoteMobSpawnCommandExecutor(RemoteMobSpawn remotemobspawn) {
		RemoteMobSpawnCommandExecutor.remotemobspawn = remotemobspawn;
	}

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
							Player player1 = Bukkit.getPlayerExact(args[0]);
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
						if (canAll) {
							if (args[0].toUpperCase().contentEquals("ALL")) {
								AllSpawnCommand.allspawncommand(sender, args);
								return true;
							}
						}
						if (canModify) {
							if (args[0].toUpperCase().contains("GLOW")) {
								if (args.length > 1) {
									if (args[1].toUpperCase().contentEquals("ON")) {
										remotemobspawn.getConfig().set("Glow", true);
										remotemobspawn.saveConfig();
										RemoteMobSpawn.Glow = true;
										remotemobspawn.getLogger().info("Glow Spawning Enabled in Config by " + sender.getName() + ".");
										sender.sendMessage("Glow Spawning set to On");
										return true;
									} else if (args[1].toUpperCase().contentEquals("OFF")) {
										remotemobspawn.getConfig().set("Glow", false);
										remotemobspawn.saveConfig();
										RemoteMobSpawn.Glow = false;
										remotemobspawn.getLogger().info("Glow Spawning Disabled in Config by " + sender.getName() + ".");
										sender.sendMessage("Glow Spawning set to Off");
										return true;
									} else {
										sender.sendMessage("Invalid Args - /rms glow [1 for on 0 for off]");
									}
								}
								return true;
							}
							if (args[0].toUpperCase().contains("SAFESPAWN")) {
								if (args.length > 1) {
									if (args[1].toUpperCase().contentEquals("ON")) {
										remotemobspawn.getConfig().set("SafeSpawn", true);
										remotemobspawn.saveConfig();
										RemoteMobSpawn.SafeSpawn = true;
										remotemobspawn.getLogger().info("SafeSpawn Enabled in Config by " + sender.getName() + ".");
										sender.sendMessage("SafeSpawn set to On");
										return true;
									} else if (args[1].toUpperCase().contentEquals("OFF")) {
										remotemobspawn.getConfig().set("SafeSpawn", false);
										remotemobspawn.saveConfig();
										RemoteMobSpawn.SafeSpawn = false;
										remotemobspawn.getLogger().info("SafeSpawn Disabled in Config by " + sender.getName() + ".");
										sender.sendMessage("SafeSpawn set to Off");
										return true;
									} else {
										sender.sendMessage("Invalid Args - /rms safespawn [on or off]");
									}
								}
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
		return false;
	}
	
	static void SafeSpawn() {
		
	}

	static void InfoSection(CommandSender sender) {
		sender.sendMessage("/rms all [mob] [amount] [distance] - Spawns on all players");
		sender.sendMessage("/rms [player] [mob] [amount] [distance] - Spawns on other");
		sender.sendMessage("/rms [mob] [amount] [distance] - Spawns on self");
		sender.sendMessage("If a mob has 2 words in the name use _ like so: ender_dragon");
	}

}
