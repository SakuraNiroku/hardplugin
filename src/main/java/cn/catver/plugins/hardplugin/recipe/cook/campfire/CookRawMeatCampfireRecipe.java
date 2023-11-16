package cn.catver.plugins.hardplugin.recipe.cook.campfire;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CookRawMeatCampfireRecipe {
    public static CampfireRecipe gen(String ID, ItemStack itemStack, RecipeChoice recipeChoice,int time){
        return new CampfireRecipe(new NamespacedKey(Hardplugin.getIns(),ID),
                itemStack,recipeChoice,0,time);
    }
}
