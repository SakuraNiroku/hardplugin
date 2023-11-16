package cn.catver.plugins.hardplugin.recipe.cook.campfire;

import org.bukkit.Material;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CookMuttonCampfireRecipe {
    public static final String ID = "mutton";
    public static CampfireRecipe gen(){
        return CookRawMeatCampfireRecipe.gen(String.format("cook%scampfirerecipe", ID),
                new ItemStack(Material.COOKED_MUTTON),new RecipeChoice.ExactChoice(new ItemStack(Material.MUTTON)),
                100);
    }
}
