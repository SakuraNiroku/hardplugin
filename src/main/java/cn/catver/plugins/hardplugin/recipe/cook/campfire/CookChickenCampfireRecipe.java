package cn.catver.plugins.hardplugin.recipe.cook.campfire;

import org.bukkit.Material;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CookChickenCampfireRecipe {
    public static final String ID = "cookchickencampfirerecipe";
    public static CampfireRecipe gen(){
        return CookRawMeatCampfireRecipe.gen(ID,
                new ItemStack(Material.COOKED_CHICKEN),new RecipeChoice.ExactChoice(new ItemStack(Material.CHICKEN)),
                1000);
    }
}
