# RemoteMobSpawn
#### Bukkit / Spigot / Minecraft / Server Plugin
#

##### Officially back on GitHub! This comes with a change to the MIT license in honor of Hacktober.

Ever had a need to spawn mobs on a player? I think we all have. RemoteMobSpawn gives you that ability! Now you can host events, set traps, or even just troll your players by spawning in mobs on or near them (even all players at once!).
Utilize command blocks for events to allow for automated spawning of mobs. This can come in handy for areas where you want animals always available. A personal favorite is using it in combination with a pressure plate or trip wire to set traps for night battle events.

#### RemoteMobSpawn v3.0.0.0 Tested On:
• 1.7.2 / 1.8 / 1.9 / 1.10 / 1.11 / 1.12

#### Features:
• Spawn mobs on other players

• Spawn mobs on yourself

• Spawn mobs on all online players

• Set distance away from the player (use negative numbers to spawn behind player)

• Set how many mobs to spawn at once

• Set if the mobs spawned with this plugin will glow with a border around them (Only available in Minecraft versions 1.9+)
 
Want to reach out or follow me? Find me on Twitter @pyropyro78
 

#### Permissions:

##### Spawn
• RemoteMobSpawn.spawn.self - Allows sender to cast /rms without a player set

• RemoteMobSpawn.spawn.other - Allows sender to cast /rms [player]

• RemoteMobSpawn.spawn.all - Allows sender to cast /rms all

• RemoteMobSpawn.spawn.glow - Allows ability to set glow per command

#####  Modify
• RemoteMobSpawn.modify - Allows sender to cast /rms (glow/safespawn)

##### Commands:
• /rms all [mob] [amount] [distance] [true/false](for Glow) - Spawns on all players

• /rms [player] [mob] [amount] [distance] [true/false](for Glow) - Spawns on other

• /rms [mob] [amount] [distance] [true/false](for Glow) - Spawns on self

• /rms glow [on/off] – Toggles default glow spawning on or off (Only in Minecraft versions 1.9+) 

• /rms safespawn [on/off] - Toggles safe spawning on/off

• /rms help – Displays commands

Use a negative distance to spawn behind the target or yourself. ex: /rms bat 1 -2
If a mob has a space in their name use the command with an underscore. ex: /rms ender_dragon 1 5
If amount and distance is left blank spawns one mob on player

###### Defaults are:
• Amount: 1
• Distance: 0 (spawns on player)

Using the command as /rms bat will spawn 1 bat on your location as an example.

#### Configs:

##### SafeSpawn: false
• When set true this will not enable mobs to spawn if the location is not in air (Will not spawn within a block).

• This is to prevent mobs from dying right when they spawn alerting the player of what is happening

• Default is: false.

##### Glow: false
• When set to true mobs spawned with the plugin will have a glow border set to them.

• Only in Minecraft versions 1.9+

#### Notes:
• Remember, always delete your old config or make the appropriate changes when updating to a newer version as things may have changed.

• Items do not stay in inventory on death if drops are toggled to not drop, they just simply do not drop them.

###### This plugin was authored by pyropyro78.
