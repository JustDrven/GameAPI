package cz.drven.gameapi.utils;

import cz.drven.gameapi.Main;
import cz.drven.gameapi.game.GameState;
import cz.drven.gameapi.objects.Colors;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class GameManager {

    private Plugin plugin;
    private int startTimer;
    private int endTimer;

    public GameManager(Plugin plugin) {
        this.plugin = plugin;
        this.startTimer = 10;
        this.endTimer = 10;
    }

    public void GameStop() {

        if (GameState.status == GameState.WAITING) return;
        if (GameState.status == GameState.INGAME) return;

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(ps -> {
                    ps.sendMessage((Main.PREFIX + Colors.format(plugin.getConfig().getString("messages.game.endmessage")))
                            .replace("%time%", String.valueOf(endTimer))
                            .replace("%prefix%", Main.PREFIX));
                });
                endTimer--;
            }
        }, 0L, 20L);
    }

    public void GameStart() {

        if (GameState.status == GameState.INGAME) return;
        if (GameState.status == GameState.RESTARTING) return;

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(ps -> {
                    ps.sendMessage((Main.PREFIX + Colors.format(plugin.getConfig().getString("messages.game.startmessage")))
                            .replace("%time%", String.valueOf(startTimer))
                            .replace("%prefix%", Main.PREFIX));
                });
                startTimer--;
            }
        }, 0L, 20L);
    }

    public static void setState(GameState s) {
        GameState.status = s;
    }

    public static boolean isState(GameState s) {
        return GameState.status == s;
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
