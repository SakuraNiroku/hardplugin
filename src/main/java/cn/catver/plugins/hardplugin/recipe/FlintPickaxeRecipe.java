package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.FlintPickaxeItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.material.MaterialData;

public class FlintPickaxeRecipe {
    public ShapedRecipe recipe;
    public static String ID = "flintpickaxe";

    public static FlintPickaxeRecipe gen(){
        FlintPickaxeRecipe flintPickaxeRecipe = new FlintPickaxeRecipe();
        flintPickaxeRecipe.recipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(), ID),FlintPickaxeItem.getItem());

        flintPickaxeRecipe.recipe.shape("jjj"," a "," a ");
        flintPickaxeRecipe.recipe.setIngredient('j',new RecipeChoice.ExactChoice(new ItemStack(Material.FLINT)));
        flintPickaxeRecipe.recipe.setIngredient('a',new RecipeChoice.ExactChoice(new ItemStack(Material.STICK)));
        return flintPickaxeRecipe;
    }
}
