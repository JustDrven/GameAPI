<h1 align="center">GameAPI</h1>

<hr>

### This API contains:
- Map system
- listeners
  - PlayerListener
  - ServerListener
- Config manager
- Game player
  - many methods
- Item utils
- Game manager
- Spectate mode
- Logger system


### How to use GamePlayer:
``` shell
GamePlayer gamePlayer = PlayerManager.getPlayer(p.getUniqueId()).get();

if (gamePlayer.isSpectating()) {  // Returns if in spectate.
  // code
} 

if (gamePlayer.isOnline()) {  // Returns if is online.
  // code
}   

gamePlayer.setSpectator();  // It will set the spectator to the player.
```
<br>

### How to use Logger:
``` shell
    // INFO message.
    Logger.log(Logger.LogType.INFO, "<message>");
    
    // WARNING message.
    Logger.log(Logger.LogType.WARNING, "<message>");

    // ERROR message.
    Logger.log(Logger.LogType.ERROR, "<message>");
```
<br>

### How to use API for Gradle:
``` shell
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.JustDrven:GameAPI:v2.0'
}
```

<hr>

<h5 align="center">This API is under copyright</h5>