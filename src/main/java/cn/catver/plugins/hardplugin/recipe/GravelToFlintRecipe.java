package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.FlintKnifeItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class GravelToFlintRecipe {
    public ShapelessRecipe recipe;
    public static String ID = "graveltoflint";

    public static GravelToFlintRecipe gen(){
        GravelToFlintRecipe gravelToFlintRecipe = new GravelToFlintRecipe();
        gravelToFlintRecipe.recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),ID),new ItemStack(Material.FLINT));
        gravelToFlintRecipe.recipe.addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.GRAVEL)));
        //gravelToFlintRecipe.recipe.addIngredient(new RecipeChoice.ExactChoice(FlintKnifeItem.getItem()));
        return gravelToFlintRecipe;
    }
}
