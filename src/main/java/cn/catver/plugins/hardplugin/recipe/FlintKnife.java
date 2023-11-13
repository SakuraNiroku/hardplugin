package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FlintKnife{
    public ShapelessRecipe recipe;
    public static String ID = "flintknife";
    public static FlintKnife gen(){
        return new FlintKnife();
    }

    public FlintKnife(){
        ItemStack itemStack = new ItemStack(Material.FLINT);
        {
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("燧石刀");
            List<String> lore = new ArrayList<>();
            lore.add("耐久：25");
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);

            NBT.modify(itemStack,nbt->{
                nbt.setString("isItTool","yes");
                nbt.setInteger("durable_hardplugin",25);
            });
        }

        recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),ID),itemStack);

        recipe.addIngredient(Material.FLINT);
        recipe.addIngredient(Material.DIRT);
    }
}
