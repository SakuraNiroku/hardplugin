package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CopperAxeItem;
import cn.catver.plugins.hardplugin.item.RawCopperCraftTableCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class CopperAxeRecipe {
    public static final String ID = "copperaxerecipe";
    public static ShapedRecipe recipe;
    static {
        recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID), CopperAxeItem.getItem());
        recipe.shape("kka","kla","pl ");
        recipe.setIngredient('p',new RecipeChoice.ExactChoice(RawCopperCraftTableCore.getItem()));
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(new ItemStack(Material.COPPER_INGOT)));
        recipe.setIngredient('a',new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_COPPER_BLOCK)));
        recipe.setIngredient('l',new RecipeChoice.ExactChoice(new ItemStack(Material.STICK)));
    }
}
