package cn.catver.plugins.hardplugin.item;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class StonePickaxeItem {
    private static ItemStack itemStack;
    static {
        itemStack = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("石镐");
        List<String> lore = new ArrayList<>();
        lore.add("耐久：100");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        NBT.modify(itemStack, nbt->{
            nbt.setString("isItTool","yes");
            nbt.setInteger("durable_hardplugin",100);
        });
    }

    public static ItemStack getItem(){
        return itemStack.clone();
    }

}
