package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftTableRecipe {
    public static final String ID = "crafttablerecipe";
    public static ShapelessRecipe gen(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),
                ID),new ItemStack(Material.CRAFTING_TABLE));
        recipe.addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.FLINT)));
        recipe.addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG)));
        recipe.addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG)));
        recipe.addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG)));

        return recipe;
    }
}
