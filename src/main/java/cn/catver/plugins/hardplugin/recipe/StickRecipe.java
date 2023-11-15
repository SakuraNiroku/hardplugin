package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class StickRecipe {
    public static String ID = "stickrecipe";
    public static ShapelessRecipe gen(){
        ItemStack i =new ItemStack(Material.STICK);
        i.setAmount(6);
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(Hardplugin.getIns(),ID),i);
        recipe.addIngredient(Material.OAK_LOG);
        recipe.addIngredient(Material.FLINT);
        return  recipe;
    }
}
