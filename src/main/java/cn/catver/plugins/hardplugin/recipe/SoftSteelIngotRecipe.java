package cn.catver.plugins.hardplugin.recipe;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.CoalCraftTableCore;
import cn.catver.plugins.hardplugin.item.SoftIronIngotItem;
import cn.catver.plugins.hardplugin.item.SoftSteelIngotItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class SoftSteelIngotRecipe {
    public static final String ID = "softsteelingotrecipe";
    public static ShapedRecipe recipe(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(Hardplugin.getIns(),ID), SoftSteelIngotItem.getItem());
        shapedRecipe.shape("   ","qwe","a  ");
        shapedRecipe.setIngredient('q',new RecipeChoice.ExactChoice(SoftIronIngotItem.getItem()));
        shapedRecipe.setIngredient('w',new RecipeChoice.ExactChoice(new ItemStack(Material.DIAMOND)));
        shapedRecipe.setIngredient('e',new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_COPPER_BLOCK)));
        shapedRecipe.setIngredient('a',new RecipeChoice.ExactChoice(CoalCraftTableCore.getItem()));
        return shapedRecipe;
    }

}
