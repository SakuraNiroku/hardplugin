package cn.catver.plugins.hardplugin.recipe.cook.campfire;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.SoftIronIngotItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class SoftIronIngotRecipe {
    public static final String ID = "softironingotrecipe";
    public static CampfireRecipe recipe(){
        CampfireRecipe recipe = new CampfireRecipe(
                new NamespacedKey(Hardplugin.getIns(),ID),
                SoftIronIngotItem.getItem(),
                new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_IRON)),
                1,
                5000
        );
        return recipe;
    }
}
