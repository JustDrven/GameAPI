package cz.drven.gameapi.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final File file;
    private final FileConfiguration config;

    public ConfigManager(Plugin plugin, String name) {
        File configFile = new File(plugin.getDataFolder(), name);
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource(name, false);
        }

        FileConfiguration config = new YamlConfiguration();

        try {

            config.load(configFile);

        } catch (IOException | InvalidConfigurationException e) {

            e.printStackTrace();

        }

        this.file = configFile;
        this.config = config;
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getConfig() {
        return config;
    }
}