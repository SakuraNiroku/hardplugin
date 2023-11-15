package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CoalBlockRecipe {
    public static String ID = "coalblockrecipe";
    public static ShapedRecipe gen(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID), new ItemStack(Material.COAL_BLOCK));
        shapedRecipe.shape("ggg","ggg","ggg");
        shapedRecipe.setIngredient('g',Material.COAL);
        return shapedRecipe;
    }
}
