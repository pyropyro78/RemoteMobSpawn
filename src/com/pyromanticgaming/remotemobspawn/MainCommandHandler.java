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

	public MainCommandHandler(RemoteMobSpawn remotemobspawn) {
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


			if (canRemoteSpawn && !args[0].equalsIgnoreCase("all") && (Bukkit.getPlayer(args[0]) instanceof Player)) {
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
						InfoDisplays.InvalidOrNeedPermission(sender);
						return true;
					} else if (!args[0].equals(sender.getName())) {
						RemoteSpawnCommand.remotespawncommand(
								sender, args, player1);
						return true;
					}
				}else {
					InfoDisplays.InvalidPlayer(sender);
					return true;
				}
			} else
				if (canAll && args[0].equalsIgnoreCase("all")) {
					AllSpawnCommand.allspawncommand(sender, args);
					return true;
				} else
					if (canModify && (args.length == 2) && args[0].equalsIgnoreCase("glow")) {
						MainConfig.SetGlow(args, sender);
						return true;
					} else
						if (canModify && (args.length == 2) && args[0].equalsIgnoreCase("safespawn")) {
							MainConfig.SafeSpawn(args, sender);
							return true;
						} else
							if (canSpawn && EntityType.valueOf(args[0].toUpperCase()).isSpawnable()) {
								// MOB0 AMOUNT1 DISTANCE2
								if (sender instanceof Player) {
									SpawnCommand.spawncommand(sender, args);
									return true;
								} else {
									InfoDisplays.MustBePlayer(sender);
									InfoDisplays.ComandSyntax(sender);
									return true;
								}
							} else
								if ((args.length == 1) && args[0].equalsIgnoreCase("help")) {
									InfoDisplays.ComandSyntax(sender);
									return true;
								} else{
									InfoDisplays.InvalidOrNeedPermission(sender);
									InfoDisplays.ComandSyntax(sender);
									return true;
								}
		}

		return false;
	}

}
