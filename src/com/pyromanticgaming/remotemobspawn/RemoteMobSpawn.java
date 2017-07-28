package com.pyromanticgaming.remotemobspawn;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoteMobSpawn extends JavaPlugin implements Listener {


	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents((Listener) this, this);

		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues();

		if (MainConfig.SafeSpawn) {
			getLogger().info("SafeSpawning Enabled in Config.");
		} else {
			getLogger().info("SafeSpawning Disabled in Config.");
		}

		if (MainConfig.Glow) {
			getLogger().info("Glow Spawning Enabled in Config.");
		} else {
			getLogger().info("Glow Spawning Disabled in Config.");
		}

		getLogger().info("RemoteMobSpawn has been enabled.");

		getCommand("rms").setExecutor(new MainCommandHandler(this));
	}

	@Override
	public void onDisable() {
		getLogger().info("RemoteMobSpawn has been disabled.");
	}

}
