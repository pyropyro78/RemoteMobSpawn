package com.pyromanticgaming.remotemobspawn;

import org.bukkit.Bukkit;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class AllSpawnCommand {

	@SuppressWarnings("unused")
	private static RemoteMobSpawn plugin;

	public AllSpawnCommand(RemoteMobSpawn instance) {
		plugin = instance;
	}

	static void allspawncommand(CommandSender sender, String[] args) {
		boolean checkformob = false;
		try{
			if(EntityType.valueOf(args[1].toUpperCase()).isSpawnable()) {
				checkformob = true;
			}
		} catch (Exception e) {

		}

		int amount = 1;
		int distance = 0;
		boolean check = false, SetGlow = false;
		// PLAYER0 MOB1 AMOUNT2 DISTANCE3 GLOW4
		if (args.length == 1) {

			InfoDisplays.InvalidArgs(sender);
			InfoDisplays.ComandSyntax(sender);

			return;
		} else
			if (args.length == 2) {
				if(MainConfig.Glow) {
					SetGlow = true;
				}
				check = true;

			} else
				if (args.length == 3) {
					try {
						if (Integer.parseInt(args[2]) >= 0) {
							amount = Integer.parseInt(args[2]);
						} else {
							InfoDisplays.InvalidAmount(sender);
						}
					} catch (Exception e) {
						InfoDisplays.InvalidAmount(sender);
					}
					if(MainConfig.Glow) {
						SetGlow = true;
					}
					check = true;

				} else
					if (args.length == 4) {
						try {
							if (Integer.parseInt(args[2]) >= 0) {
								amount = Integer.parseInt(args[2]);
							} else {
								InfoDisplays.InvalidAmount(sender);
							}
						} catch (Exception e) {
							InfoDisplays.InvalidAmount(sender);
						}
						try {
							if (Integer.parseInt(args[3]) >= 0) {
								distance = Integer.parseInt(args[3]);
							} else {
								InfoDisplays.InvalidDistance(sender);
							}
						} catch (Exception e) {
							InfoDisplays.InvalidDistance(sender);
						}
						if(MainConfig.Glow) {
							SetGlow = true;
						}
						check = true;

					} else
						if (RemoteMobSpawn.NotLegacy && args.length == 5 && (sender.hasPermission("RemoteMobSpawn.spawn.glow") || sender.isOp())) {
							try {
								if (Integer.parseInt(args[2]) >= 0) {
									amount = Integer.parseInt(args[2]);
								} else {
									InfoDisplays.InvalidAmount(sender);
								}
							} catch (Exception e) {
								InfoDisplays.InvalidAmount(sender);
							}
							try {
								if (Integer.parseInt(args[3]) >= 0) {
									distance = Integer.parseInt(args[3]);
								} else {
									InfoDisplays.InvalidDistance(sender);
								}
							} catch (Exception e) {
								InfoDisplays.InvalidDistance(sender);
							}
							try {
								if (args[4].equalsIgnoreCase("true") || args[4].equalsIgnoreCase("false")) {
									SetGlow = Boolean.parseBoolean(args[4]);
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
							if (RemoteMobSpawn.NotLegacy && args.length == 5 && !(sender.hasPermission("RemoteMobSpawn.spawn.glow") || sender.isOp())) {
								InfoDisplays.InvalidGlowPermission(sender);


							} else
								if (RemoteMobSpawn.NotLegacy && args.length == 5) {
									InfoDisplays.LegacyWarning(sender);

								} else {
									InfoDisplays.InvalidArgs(sender);
									InfoDisplays.ComandSyntax(sender);
								}

		if (check == true && checkformob) {
			for (Player player1 : Bukkit.getServer().getOnlinePlayers()) {
				String uppername = args[1].toUpperCase();

				SimplifiedSpawning.FindRelativeDirection(distance, uppername, amount, player1, sender, SetGlow);
			}
			return;
		} else if (!checkformob) {
			InfoDisplays.InvalidMob(sender);
		}

	}

}
