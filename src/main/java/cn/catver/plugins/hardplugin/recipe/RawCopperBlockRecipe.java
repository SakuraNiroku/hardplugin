package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CoalCraftTableCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class RawCopperBlockRecipe {
    public static final String ID = "rawcopperblockrecipe";
    public static ShapedRecipe recipe;
    static {
        recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID),new ItemStack(Material.RAW_COPPER_BLOCK));
        recipe.shape("ggg","gkg","ggg");
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(CoalCraftTableCore.getItem()));
        recipe.setIngredient('g',new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_COPPER)));
    }
}
