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


        recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),ID), cn.catver.plugins.hardplugin.item.FlintKnife.getItem());

        recipe.addIngredient(Material.FLINT);
        recipe.addIngredient(Material.DIRT);
    }
}
