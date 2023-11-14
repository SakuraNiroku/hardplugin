package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.FlintKnifeItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;

public class FlintKnifeRecipe {
    public ShapelessRecipe recipe;
    public static String ID = "flintknife";
    public static FlintKnifeRecipe gen(){
        return new FlintKnifeRecipe();
    }

    public FlintKnifeRecipe(){


        recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),ID), FlintKnifeItem.getItem());

        recipe.addIngredient(Material.FLINT);
        recipe.addIngredient(Material.DIRT);
    }
}
