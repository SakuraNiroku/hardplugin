package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CoalCraftTableCore;
import cn.catver.plugins.hardplugin.item.RawCopperPickaxeItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.material.MaterialData;

public class RawCopperPickaxeRecipe {
    public static final String ID = "rawcopperpickaxerecipe";
    public static ShapedRecipe recipe;
    static {
        recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID), RawCopperPickaxeItem.getItem());
        recipe.shape("kkk","klk","alp");
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_COPPER)));
        recipe.setIngredient('l',new RecipeChoice.ExactChoice(new ItemStack(Material.STICK)));
        recipe.setIngredient('a',new RecipeChoice.ExactChoice(CoalCraftTableCore.getItem()));
        recipe.setIngredient('p',new RecipeChoice.ExactChoice(new ItemStack(Material.LAPIS_LAZULI)));
    }
}
