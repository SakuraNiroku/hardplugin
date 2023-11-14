package cn.catver.plugins.hardplugin.item;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FlintKnife {
    private static ItemStack itemStack;
    static {
        itemStack = new ItemStack(Material.WOODEN_SHOVEL);
        {
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("燧石刀");
            List<String> lore = new ArrayList<>();
            lore.add("耐久：25");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemStack.setItemMeta(itemMeta);

            NBT.modify(itemStack, nbt->{
                nbt.setString("isItTool","yes");
                nbt.setInteger("durable_hardplugin",25);
            });
        }
    }
    public static ItemStack getItem(){
        return itemStack.clone();
    }
}
