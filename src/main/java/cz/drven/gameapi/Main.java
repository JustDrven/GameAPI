package cz.drven.gameapi;

import cz.drven.gameapi.object.Colors;
import cz.drven.gameapi.object.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String PREFIX = Colors.format("&8[&cGame&8] &r");

    @Override
    public void onEnable() {
        try {
            Logger.log(Logger.LogType.INFO, "&aAPI was been enabled!");
        } catch (Exception ex) {
            Logger.log(Logger.LogType.ERROR, "Error with API");
        }
    }
}
