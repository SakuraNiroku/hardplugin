package cn.catver.plugins.hardplugin.recipe.cook.campfire;

import org.bukkit.Material;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CookPorkchopCampfireRecipe {
    public static final String ID = "cookporkchopcampfirerecipe";
    public static CampfireRecipe gen(){
        return CookRawMeatCampfireRecipe.gen(ID,
                new ItemStack(Material.COOKED_PORKCHOP),new RecipeChoice.ExactChoice(new ItemStack(Material.PORKCHOP)),
                1000);
    }
}
