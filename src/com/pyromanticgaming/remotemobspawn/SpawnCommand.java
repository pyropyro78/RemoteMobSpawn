package com.pyromanticgaming.remotemobspawn;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnCommand {

	@SuppressWarnings("unused")
	private static RemoteMobSpawn plugin;

	public SpawnCommand(RemoteMobSpawn instance) {
		plugin = instance;
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
			InfoDisplays.InvalidNumberOfArgs(sender);
			InfoDisplays.InfoSection(sender);
		}

		// MOB0 AMOUNT1 DISTANCE2
		Player player = (Player) sender;
		Location loc = player.getLocation();
		int disx = 0;
		int disz = 0;
		double direction = (loc.getYaw());

		SimplifiedSpawning.FindRelativeDirection(distance, disx, disz, direction);

		Location newloc = null;

		SimplifiedSpawning.SafeSpawning(loc, newloc, disx, disz, sender, amount);
		
		String uppername = args[0].toUpperCase();
		if(EntityType.valueOf(uppername).isSpawnable()) {
			while (amount > 0) {
				player.getWorld().spawnEntity(newloc, EntityType.valueOf(uppername)).setGlowing(MainConfig.Glow);
				amount--;
			}
			return;
		}
		else if(!EntityType.valueOf(uppername).isSpawnable()) {
			InfoDisplays.InvalidMob(sender);
		}
	}

}
