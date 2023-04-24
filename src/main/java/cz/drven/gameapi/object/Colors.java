package cz.drven.gameapi.object;

import org.bukkit.ChatColor;

public class Colors {

    public static String format(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
