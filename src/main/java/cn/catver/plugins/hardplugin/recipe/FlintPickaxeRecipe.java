package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.FlintPickaxeItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.material.MaterialData;

public class FlintPickaxeRecipe {
    public ShapedRecipe recipe;
    public static String ID = "flintpickaxe";

    public static FlintPickaxeRecipe gen(){
        FlintPickaxeRecipe flintPickaxeRecipe = new FlintPickaxeRecipe();
        flintPickaxeRecipe.recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(), ID),FlintPickaxeItem.getItem());

        flintPickaxeRecipe.recipe.shape("jjj"," a "," a ");
        flintPickaxeRecipe.recipe.setIngredient('j',Material.FLINT);
        flintPickaxeRecipe.recipe.setIngredient('a',Material.STICK);
        return flintPickaxeRecipe;
    }
}
