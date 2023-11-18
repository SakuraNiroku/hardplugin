package cn.catver.plugins.hardplugin.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoftSteelIngotItem {
    private static ItemStack itemStack;
    static {
        itemStack = new ItemStack(Material.IRON_INGOT);
        {
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BLUE+"软钢锭");
            itemStack.setItemMeta(itemMeta);

        }
    }

    public static ItemStack getItem(){
        return itemStack.clone();
    }
}
