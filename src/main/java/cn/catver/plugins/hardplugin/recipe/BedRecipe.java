package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CoalCraftTableCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class BedRecipe {
    public static final String ID = "bedrecipe";
    public static ShapedRecipe gen(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID),new ItemStack(Material.WHITE_BED));
        recipe.shape("   ","ggg","kjj");
        recipe.setIngredient('g',new RecipeChoice.ExactChoice(new ItemStack(Material.WHITE_WOOL)));
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(CoalCraftTableCore.getItem()));
        recipe.setIngredient('j',new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG)));
        return recipe;
    }
}
