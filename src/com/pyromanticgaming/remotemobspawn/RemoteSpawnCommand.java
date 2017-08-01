package com.pyromanticgaming.remotemobspawn;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class RemoteSpawnCommand {

	@SuppressWarnings("unused")
	private static RemoteMobSpawn plugin;

	public RemoteSpawnCommand(RemoteMobSpawn instance) {
		plugin = instance;
	}

	static void remotespawncommand(CommandSender sender, String[] args, Player player1) {
		int amount = 1;
		int distance = 0;
		boolean check = false, SetGlow = false;
		// PLAYER0 MOB1 AMOUNT2 DISTANCE3
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
					amount = Integer.parseInt(args[2]);
					if(MainConfig.Glow) {
						SetGlow = true;
					}
					check = true;

				} else
					if (args.length == 4) {
						amount = Integer.parseInt(args[2]);
						distance = Integer.parseInt(args[3]);
						if(MainConfig.Glow) {
							SetGlow = true;
						}
						check = true;

					} else
						if (RemoteMobSpawn.NotLegacy && args.length == 5 && (sender.hasPermission("RemoteMobSpawn.spawn.glow") || sender.isOp())) {
							amount = Integer.parseInt(args[2]);
							distance = Integer.parseInt(args[3]);
							SetGlow = Boolean.parseBoolean(args[3]);

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

		if (check == true) {


			String uppername = args[1].toUpperCase();
			if(EntityType.valueOf(uppername).isSpawnable()) {
				SimplifiedSpawning.FindRelativeDirection(distance, uppername, amount, player1, sender, SetGlow);
			} else
				if(!EntityType.valueOf(uppername).isSpawnable()) {
					InfoDisplays.InvalidMob(sender);
				}
		}

	}

}
