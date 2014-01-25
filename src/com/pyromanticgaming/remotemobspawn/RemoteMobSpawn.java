package com.pyromanticgaming.remotemobspawn;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoteMobSpawn extends JavaPlugin implements Listener {

	public static boolean SafeSpawn = false;
	
	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents((Listener) this, this);
		
		this.saveDefaultConfig();
		SafeSpawn = this.getConfig().getBoolean("SafeSpawn");
		if (SafeSpawn) {
			getLogger().info("SafeSpawning Enabled in Config.");
		} else {
			getLogger().info("SafeSpawning Disabled in Config.");
		}
		
		getLogger().info("RemoteMobSpawn has been enabled.");

		getCommand("rms").setExecutor(new RemoteMobSpawnCommandExecutor(this));
	}

	@Override
	public void onDisable() {
		getLogger().info("RemoteMobSpawn has been disabled.");
	}

}
