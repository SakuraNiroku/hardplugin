package cn.catver.plugins.hardplugin.recipe.cook.furnace;

import cn.catver.plugins.hardplugin.Hardplugin;
import cn.catver.plugins.hardplugin.item.SoftSteelIngotItem;
import cn.catver.plugins.hardplugin.item.SteelIngotItem;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.RecipeChoice;

public class SteelIngotRecipe {
    public static final String ID = "steelingotrecipe";
    public static FurnaceRecipe recipe(){
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(
                new NamespacedKey(Hardplugin.getIns(),ID),
                SteelIngotItem.getItem(),
                new RecipeChoice.ExactChoice(SoftSteelIngotItem.getItem()),
                0,
                10000
        );
        return furnaceRecipe;
    }
}
