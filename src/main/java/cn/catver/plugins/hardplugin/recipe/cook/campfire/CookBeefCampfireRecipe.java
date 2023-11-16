package cn.catver.plugins.hardplugin.recipe.cook.campfire;

import org.bukkit.Material;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CookBeefCampfireRecipe {
    public static String ID = "beef";
    public static CampfireRecipe gen(){
        return CookRawMeatCampfireRecipe.gen(String.format("cook%scampfirerecipe", ID),
                new ItemStack(Material.COOKED_BEEF),new RecipeChoice.ExactChoice(new ItemStack(Material.BEEF)),
                100);
    }
}
