package cz.drven.gameapi;

import cz.drven.gameapi.listeners.PlayerListener;
import cz.drven.gameapi.object.Colors;
import cz.drven.gameapi.object.Logger;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String PREFIX = Colors.format("&8[&cGame&8] &r");

    @Override
    public void onEnable() {

        try {
            // setup
            PluginManager pm = getServer().getPluginManager();

            // listeners
            pm.registerEvents(new PlayerListener(), this);

            Logger.log(Logger.LogType.INFO, "&aAPI was been enabled!");
        } catch (Exception ex) {
            Logger.log(Logger.LogType.ERROR, "Error with API");
        }

    }
}
