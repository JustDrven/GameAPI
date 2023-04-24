package cz.drven.gameapi.listeners;

import cz.drven.gameapi.game.GamePlayer;
import cz.drven.gameapi.game.PlayerManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        PlayerManager.addPlayer(new GamePlayer(e.getPlayer().getUniqueId()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        PlayerManager.removePlayer(e.getPlayer().getUniqueId());
    }

}
