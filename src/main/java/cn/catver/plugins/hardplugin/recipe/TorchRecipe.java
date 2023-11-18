package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class TorchRecipe {
    public static final String ID = "torchrecipe";
    public static ShapedRecipe gen(){
        ItemStack itemStack = new ItemStack(Material.TORCH);
        itemStack.setAmount(16);
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID),itemStack);
        shapedRecipe.shape("aaa","kkk","aaa");
        shapedRecipe.setIngredient('a',new RecipeChoice.ExactChoice(new ItemStack(Material.STICK)));
        shapedRecipe.setIngredient('k',new RecipeChoice.ExactChoice(new ItemStack(Material.FLINT)));
        return shapedRecipe;
    }
}
