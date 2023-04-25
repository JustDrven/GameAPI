package cz.drven.gameapi.listeners;

import cz.drven.gameapi.Main;
import cz.drven.gameapi.game.GameState;
import cz.drven.gameapi.objects.Colors;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    private Main pl;

    public ServerListener(Main pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if (GameState.status == GameState.WAITING) {
            e.setMotd(Colors.format(pl.getConfig().getString("game.status.waiting")));
        }
        if (GameState.status == GameState.INGAME) {
            e.setMotd(Colors.format(pl.getConfig().getString("game.status.ingame")));
        }
        if (GameState.status == GameState.RESTARTING) {
            e.setMotd(Colors.format(pl.getConfig().getString("game.status.restarting")));
        }
    }

}
