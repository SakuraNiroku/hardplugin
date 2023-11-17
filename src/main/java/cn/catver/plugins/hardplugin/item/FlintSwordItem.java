package cn.catver.plugins.hardplugin.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FlintSwordItem {
    private static ItemStack itemStack;
    static {
        itemStack = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("燧石剑");
        itemStack.setItemMeta(itemMeta);
        itemStack.addEnchantment(Enchantment.DAMAGE_ALL,1);
    }

    public static ItemStack getItem(){
        return itemStack.clone();
    }
}
