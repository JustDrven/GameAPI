package cz.drven.gameapi.utils;

import cz.drven.gameapi.objects.Colors;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    public static ItemStack item(Material m, int a, int data, String displayname, List<String> list) {

        ItemStack is = new ItemStack(m, a, (byte)data);
        ItemMeta ismeta = is.getItemMeta();
        ismeta.setDisplayName(Colors.format(displayname));
        ismeta.setLore(list);
        is.setItemMeta(ismeta);

        return is;
    }

}
