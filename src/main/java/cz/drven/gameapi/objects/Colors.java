package cz.drven.gameapi.objects;

import org.bukkit.ChatColor;

public class Colors {

    public static String format(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
