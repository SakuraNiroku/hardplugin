package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class GravelToFlint {
    public ShapelessRecipe recipe;
    public static String ID = "graveltoflint";

    public static GravelToFlint gen(){
        GravelToFlint gravelToFlint = new GravelToFlint();
        gravelToFlint.recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),ID),new ItemStack(Material.FLINT));
        gravelToFlint.recipe.addIngredient(Material.GRAVEL);
        return gravelToFlint;
    }
}
