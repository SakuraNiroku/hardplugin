package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class ChestRecipe {
    public static String ID = "chestrecipe";
    public static ShapedRecipe gen(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID), new ItemStack(Material.CHEST));
        shapedRecipe.shape("ggg","gag","ggg");
        shapedRecipe.setIngredient('g',new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG)));
        shapedRecipe.setIngredient('a',new RecipeChoice.ExactChoice(new ItemStack(Material.FLINT)));
        return shapedRecipe;
    }
}
