package com.pyromanticgaming.remotemobspawn;

import org.bukkit.Bukkit;



import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoteMobSpawn extends JavaPlugin implements Listener {

	public static boolean NotLegacy = false;

	@Override
	public void onEnable() {
		getLogger().info("RemoteMobSpawn loading started.");
		getServer().getPluginManager().registerEvents((Listener) this, this);

		if(Bukkit.getVersion().contains("1.9") || Bukkit.getVersion().contains("1.1")) {
			NotLegacy = true;
		}

		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues();

		if (MainConfig.SafeSpawn) {
			getLogger().info("SafeSpawning Enabled in Config.");
		} else {
			getLogger().info("SafeSpawning Disabled in Config.");
		}
		if(NotLegacy) {
			if (MainConfig.Glow) {
				getLogger().info("Glow Spawning Enabled in Config.");
			} else {
				getLogger().info("Glow Spawning Disabled in Config.");
			}
		}

		getCommand("rms").setExecutor(new MainCommandHandler(this));

		getLogger().info("RemoteMobSpawn has been loaded.");
	}

	@Override
	public void onDisable() {
		getLogger().info("RemoteMobSpawn has been disabled.");
	}

}
