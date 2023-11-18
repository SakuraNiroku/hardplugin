package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.RawCopperCraftTableCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class FurnaceRecipe {
    public static final String ID = "furnacerecipe";
    public static ShapedRecipe recipe;
    static {
        recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID),new ItemStack(Material.FURNACE));
        recipe.shape("ooo","olk","ooo");
        recipe.setIngredient('o',new RecipeChoice.ExactChoice(new ItemStack(Material.COBBLESTONE)));
        recipe.setIngredient('l',new RecipeChoice.ExactChoice(RawCopperCraftTableCore.getItem()));
        recipe.setIngredient('k',new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_COPPER_BLOCK)));
    }
}
