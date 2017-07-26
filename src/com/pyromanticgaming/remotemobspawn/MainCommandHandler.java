package com.pyromanticgaming.remotemobspawn;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MainCommandHandler implements CommandExecutor {

	protected static RemoteMobSpawn remotemobspawn;

	public MainCommandHandler(RemoteMobSpawn remotemobspawn) {
		MainCommandHandler.remotemobspawn = remotemobspawn;
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

			if (args.length > 0) {
				if (canRemoteSpawn) {
					if (Bukkit.getPlayer(args[0]) instanceof Player) {
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
								InfoDisplays.NeedPermission(sender);
								return true;
							} else if (!args[0].equals(sender.getName())) {
								RemoteSpawnCommand.remotespawncommand(
										sender, args, player1);
								return true;
							}
						}
					}else {
						InfoDisplays.InvalidPlayer(sender);
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
						MainConfig.SetGlow(args, sender);
						return true;
					}
					if (args[0].toUpperCase().contains("SAFESPAWN")) {
						MainConfig.SafeSpawn(args, sender);
						return true;
					}
				}
				if (canSpawn) {
					for (EntityType c : EntityType.values()) {
						// MOB0 AMOUNT1 DISTANCE2
						if (args[0].equalsIgnoreCase(c.name())) {
							if (sender instanceof Player) {
								SpawnCommand.spawncommand(sender, args);
								return true;
							} else {
								InfoDisplays.MustBePlayer(sender);
								InfoDisplays.InfoSection(sender);
								return true;
							}
						}
					}
				} else {
					InfoDisplays.NeedPermission(sender);
					return true;
				}
			}

		}
		return false;
	}

}
