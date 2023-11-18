package cn.catver.plugins.hardplugin.recipe.cook.furnace;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CopperIngotRecipe {
    public static final String ID = "copperingotrecipe";
    public static FurnaceRecipe recipe;
    static {
        recipe = new FurnaceRecipe(
                new NamespacedKey(Hardplugin.getIns(),ID),
                new ItemStack(Material.COPPER_INGOT),
                new RecipeChoice.ExactChoice(new ItemStack(Material.RAW_COPPER)),
                10,
                2000
        );
    }
}
