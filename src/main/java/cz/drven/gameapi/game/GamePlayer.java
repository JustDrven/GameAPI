package cz.drven.gameapi.game;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GamePlayer {

    private UUID uuid;
    private boolean spectating = false;

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public OfflinePlayer getOfflinePlayer() {
        return Bukkit.getOfflinePlayer(uuid);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public boolean isOnline() {
        return getOfflinePlayer().isOnline();
    }


    public boolean isSpectating() {
        return spectating;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setSpectator() {
        spectating = true;
        if (this.getPlayer() == null) return;

        this.getPlayer().setGameMode(GameMode.ADVENTURE);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (this.getPlayer().equals(player)) continue;
                player.hidePlayer(this.getPlayer());
            }

        this.getPlayer().setAllowFlight(true);
        this.getPlayer().setFlying(true);
        this.getPlayer().spigot().setCollidesWithEntities(false);

    }

}
