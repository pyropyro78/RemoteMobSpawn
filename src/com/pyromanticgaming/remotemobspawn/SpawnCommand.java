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
		String uppername = args[0].toUpperCase();
		if(EntityType.valueOf(uppername).isSpawnable()) {
			SimplifiedSpawning.FindRelativeDirection(distance, uppername, amount, player, sender);
		} else
			if(!EntityType.valueOf(uppername).isSpawnable()) {
				InfoDisplays.InvalidMob(sender);
			}
	}

}
