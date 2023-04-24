package cz.drven.gameapi.game;

import org.bukkit.OfflinePlayer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class PlayerManager {

    private static Set<GamePlayer> players = new HashSet<>();

    public static Optional<GamePlayer> getPlayer(UUID uuid) {
        return getPlayers().stream()
                .filter(bwPlayer -> bwPlayer.getUUID().equals(uuid))
                .findAny();
    }

    public static Set<GamePlayer> getPlayers() {
        return players;
    }

    public static Optional<GamePlayer> getPlayer(OfflinePlayer player) {
        return getPlayer(player.getUniqueId());
    }
    public static void addPlayer(GamePlayer gamePlayer) {
        players.add(gamePlayer);
    }

    public static void removePlayer(UUID uuid) {

        players.removeIf((bwPlayer) -> bwPlayer.getUUID().equals(uuid));
    }



}
