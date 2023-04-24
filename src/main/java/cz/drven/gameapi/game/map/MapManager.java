package cz.drven.gameapi.game.map;

import java.util.HashSet;
import java.util.Set;

public class MapManager {

    private static Set<Map> maps = new HashSet<>();

    public static Set<Map> getMaps() {
        return maps;
    }

    public static void registerMap(String name) {
        maps.add(new Map(name));
    }

    public static void delMap(String name) {
        maps.removeIf((map) -> map.equals(name));
    }

}
