package cz.drven.gameapi;

import cz.drven.gameapi.listeners.PlayerListener;
import cz.drven.gameapi.listeners.ServerListener;
import cz.drven.gameapi.objects.Colors;
import cz.drven.gameapi.objects.Logger;
import cz.drven.gameapi.utils.ConfigManager;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String PREFIX = Colors.format("&8[&cServer&8] &r");
    private static ConfigManager config;
    private static ConfigManager message;

    @Override
    public void onEnable() {
        try {
            // config and managers
            saveDefaultConfig();

            config = new ConfigManager(this, "mysql.yml");
            config.getConfig().save("mysql.yml");

            message = new ConfigManager(this, "messages.yml");
            message.getConfig().save("messages.yml");

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
            // error message
            Logger.log(Logger.LogType.ERROR, "Error with API");
        }

    }
}
