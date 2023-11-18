package cn.catver.plugins.hardplugin.item;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CopperAxeItem {
    private static ItemStack itemStack;
    static {
        itemStack = new ItemStack(Material.STONE_AXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("铜斧头");
        List<String> lore = new ArrayList<>();
        lore.add("耐久：275");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        itemStack.addEnchantment(Enchantment.DAMAGE_ALL,2);
        itemStack.addEnchantment(Enchantment.DIG_SPEED,2);

        NBT.modify(itemStack, nbt->{
            nbt.setString("isItTool","yes");
            nbt.setInteger("durable_hardplugin",275);
        });
    }

    public static ItemStack getItem(){
        return itemStack.clone();
    }
}
