package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CoalCraftTableCore;
import cn.catver.plugins.hardplugin.item.FlintSwordItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class FlintSwordRecipe {
    public static final String ID = "flintswordrecipe";
    public static ShapedRecipe gen(){
        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(Hardplugin.getIns(),ID),
                FlintSwordItem.getItem()
        );
        recipe.shape(" k ","ak "," j ");
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(new ItemStack(Material.FLINT)));
        recipe.setIngredient('a',new RecipeChoice.ExactChoice(CoalCraftTableCore.getItem()));
        recipe.setIngredient('j',new RecipeChoice.ExactChoice(new ItemStack(Material.STICK)));
        return recipe;
    }
}
