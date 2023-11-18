package cn.catver.plugins.hardplugin;

import cn.catver.plugins.hardplugin.recipe.*;
import cn.catver.plugins.hardplugin.recipe.cook.CopperIngotRecipe;
import cn.catver.plugins.hardplugin.recipe.cook.campfire.CookBeefCampfireRecipe;
import cn.catver.plugins.hardplugin.recipe.cook.campfire.CookChickenCampfireRecipe;
import cn.catver.plugins.hardplugin.recipe.cook.campfire.CookMuttonCampfireRecipe;
import cn.catver.plugins.hardplugin.recipe.cook.campfire.CookPorkchopCampfireRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RecipeRegister {
    HashMap<String, Recipe> recipes = new HashMap<>();

    public RecipeRegister(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();

        //TODO 写在这里
        recipes.put(FlintKnifeRecipe.ID, FlintKnifeRecipe.gen().recipe);
        recipes.put(GravelToFlintRecipe.ID, GravelToFlintRecipe.gen().recipe);
        recipes.put(FlintPickaxeRecipe.ID,FlintPickaxeRecipe.gen().recipe);
        recipes.put(StickRecipe.ID,StickRecipe.gen());
        recipes.put(CoalBlockRecipe.ID,CoalBlockRecipe.gen());
        recipes.put(CampfireRecipe.ID,CampfireRecipe.gen());

        recipes.put(CookBeefCampfireRecipe.ID,CookBeefCampfireRecipe.gen());
        recipes.put(CookChickenCampfireRecipe.ID,CookChickenCampfireRecipe.gen());
        recipes.put(CookMuttonCampfireRecipe.ID,CookMuttonCampfireRecipe.gen());
        recipes.put(CookPorkchopCampfireRecipe.ID,CookPorkchopCampfireRecipe.gen());

        recipes.put(CraftTableRecipe.ID,CraftTableRecipe.gen());
        recipes.put(StonePickaxeRecipe.ID,StonePickaxeRecipe.gen());
        recipes.put(FlintSwordRecipe.ID,FlintSwordRecipe.gen());
        recipes.put(BedRecipe.ID,BedRecipe.gen());
        recipes.put(TorchRecipe.ID,TorchRecipe.gen());
        recipes.put(RawCopperPickaxeRecipe.ID,RawCopperPickaxeRecipe.recipe);
        recipes.put(RawCopperBlockRecipe.ID,RawCopperBlockRecipe.recipe);
        recipes.put(FurnaceRecipe.ID,FurnaceRecipe.recipe);
        recipes.put(CopperIngotRecipe.ID,CopperIngotRecipe.recipe);
        recipes.put(CopperAxeRecipe.ID,CopperAxeRecipe.recipe);


        logger.info("开始导入配方");
        for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {
            Bukkit.addRecipe(entry.getValue());
            logger.info(String.format("%s配方已导入完成！", entry.getKey()));
        }
        logger.info("配方导入完成！");

    }

    public void unload(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();

        logger.info("开始卸载配方");
        for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {
            Bukkit.removeRecipe(new NamespacedKey(hardplugin,entry.getKey()));
            logger.info(String.format("%s配方已卸载！", entry.getKey()));
        }
        logger.info("配方卸载完成！");
    }
}
