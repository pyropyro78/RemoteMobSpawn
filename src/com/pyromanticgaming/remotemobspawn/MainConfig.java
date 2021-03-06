package com.pyromanticgaming.remotemobspawn;


import org.bukkit.command.CommandSender;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.pyromanticgaming.remotemobspawn.RemoteMobSpawn;

public class MainConfig {

	private static RemoteMobSpawn plugin;

	public MainConfig(RemoteMobSpawn instance) {
		plugin = instance;
	}


	public static boolean SafeSpawn = false, Glow = false;

	public static void GetMainValues() {

		SafeSpawn = plugin.getConfig().getBoolean("SafeSpawn");
		Glow = plugin.getConfig().getBoolean("Glow");

	}

	static void SetGlow(String args[], CommandSender sender) {
		if(RemoteMobSpawn.NotLegacy) {
			if (args.length == 2) {
				Glow = Boolean.parseBoolean(args[1]);

				if (Glow) {
					plugin.getConfig().set("Glow", true);
					plugin.saveConfig();
					plugin.getLogger().info("Glow Default Spawning Enabled in Config by " + sender.getName() + ".");
					InfoDisplays.GlowTrue(sender);
					return;
				} else
					if (!Glow) {
						plugin.getConfig().set("Glow", false);
						plugin.saveConfig();
						plugin.getLogger().info("Glow Default Spawning Disabled in Config by " + sender.getName() + ".");
						InfoDisplays.GlowFalse(sender);
						return;
					}
			} else 
				if (!(args.length == 2)){
					InfoDisplays.InvalidArgs(sender);
					InfoDisplays.ComandSyntax(sender);
				}
		} else {
			InfoDisplays.LegacyWarning(sender);
		}
	}

	static void SafeSpawn(String args[], CommandSender sender) {
		if (args.length > 1) {
			if (args[1].toUpperCase().contentEquals("ON")) {
				plugin.getConfig().set("SafeSpawn", true);
				plugin.saveConfig();
				MainConfig.SafeSpawn = true;
				plugin.getLogger().info("SafeSpawn Enabled in Config by " + sender.getName() + ".");
				InfoDisplays.SafeSpawnOn(sender);
				return;
			} else if (args[1].toUpperCase().contentEquals("OFF")) {
				plugin.getConfig().set("SafeSpawn", false);
				plugin.saveConfig();
				MainConfig.SafeSpawn = false;
				plugin.getLogger().info("SafeSpawn Disabled in Config by " + sender.getName() + ".");
				InfoDisplays.SafeSpawnOff(sender);
				return;
			} else {
				InfoDisplays.InvalidArgs(sender);
				InfoDisplays.ComandSyntax(sender);
			}
		}
	}


}