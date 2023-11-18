package cn.catver.plugins.hardplugin.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RawCopperCraftTableCore {
    private static ItemStack itemStack;
    static {
        itemStack = new ItemStack(Material.BRICK);
        {
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.YELLOW+"粗铜工作台核心");
            itemStack.setItemMeta(itemMeta);

        }
    }

    public static ItemStack getItem(){
        return itemStack.clone();
    }
}
