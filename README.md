The goal of this plugin is to allow an admin or a person with the permissions to remotely spawn mobs on or near a player via commands. The use of this plugin would be for events where you need to spawn mobs but don't want them to be near another player, or to just mess with your players and spawn them nearby. This will also allow the casting of mobs at the caster's location.

Works with command blocks!

Permissions:

    RemoteMobSpawn.spawn.self - Allows sender to cast /rms without a player set
    RemoteMobSpawn.spawn.other - Allows sender to cast /rms [player] 

Commands:

    /rms [player] [mob] [amount] [distance] - Spawns on other
    /rms [mob] [amount] [distance] - Spawns on self 
    
    (as of v2.1.1.1+)

    /rms all [mob] [amount] [distance] - Spawns on all players 

Use a negative distance to spawn behind the target or yourself. ex: /rms bat 1 -2

remotemobspawn can be used in place of rms

Defaults are:

    Amount: 1
    Distance: 0 (spawns on player) 

Using the command as /rms bat will spawn 1 bat on your location as an example.

Features:

    Spawn mobs on other players.
    Spawn mobs on yourself. 
    
    (as of v2.1.1.1+)

    Spawns mobs on All players 

Config:

    When set true this will not enable mobs to spawn if the location is not in air.
    This is to prevent mobs from dying right when they spawn alerting the player of what is happening.
    Default is: false. 
    
    SafeSpawn: false
    
Metrics:

(Not in v2.1.1.0+)

This plugin utilizes Hidendra's plugin metrics system, which means that the following information is collected and sent to mcstats.org:

    A unique identifier
    The server's version of Java
    Whether the server is in offline or online mode
    The plugin's version
    The server's version
    The OS version/name and architecture
    The core count for the CPU
    The number of players online
    The Metrics version
    You can disable the stat collection via /plugins/PluginMetrics/config.yml if you wish. (But that is not very nice :( ) 

This plugin was authored by pyropyro78.
