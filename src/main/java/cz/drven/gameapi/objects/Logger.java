package cz.drven.gameapi.objects;

import org.bukkit.Bukkit;

public class Logger {

    public static void log(LogType type, String s) {
        Bukkit.getServer().getConsoleSender().sendMessage(Colors.format("&8[&cGameAPI&8] &7(&e" + type.name() + "&7) &8- &r" + s));
    }

    public enum LogType {
        INFO, ERROR, WARNING
    }

}
