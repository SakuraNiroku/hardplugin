package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CoalCraftTableCore;
import cn.catver.plugins.hardplugin.item.StonePickaxeItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class StonePickaxeRecipe {
    public static final String ID = "stonepickaxerecipe";
    public static ShapedRecipe gen(){
        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(Hardplugin.getIns(),ID),
                StonePickaxeItem.getItem()
        );

        recipe.shape("jjj","klo"," l ");
        recipe.setIngredient('j',new RecipeChoice.ExactChoice(new ItemStack(Material.FLINT)));
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(new ItemStack(Material.COAL_BLOCK)));
        recipe.setIngredient('o',new RecipeChoice.ExactChoice(CoalCraftTableCore.getItem()));
        return recipe;
    }
}
