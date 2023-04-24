package cz.drven.gameapi;

import cz.drven.gameapi.game.map.MapManager;
import cz.drven.gameapi.listeners.PlayerListener;
import cz.drven.gameapi.listeners.ServerListener;
import cz.drven.gameapi.object.Colors;
import cz.drven.gameapi.object.Logger;

import cz.drven.gameapi.utils.ConfigManager;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    public static final String PREFIX = Colors.format("&8[&cServer&8] &r");
    private static ConfigManager config;

    @Override
    public void onEnable() {
        try {
            saveDefaultConfig();

            config = new ConfigManager(this, "mysql.yml");

            config.getConfig().save("mysql.yml");

            Logger.log(Logger.LogType.INFO, "&aConfig was been created!");

        } catch (Exception ex) {
            Logger.log(Logger.LogType.WARNING, "&cConfig was been deleted!");
        }
        try {
            // setup
            PluginManager pm = getServer().getPluginManager();

            // listeners
            pm.registerEvents(new PlayerListener(), this);
            pm.registerEvents(new ServerListener(this), this);

            Logger.log(Logger.LogType.INFO, "&aAPI was been enabled!");
        } catch (Exception ex) {
            Logger.log(Logger.LogType.ERROR, "Error with API");
        }

    }
}
