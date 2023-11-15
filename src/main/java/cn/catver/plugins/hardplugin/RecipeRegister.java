package cn.catver.plugins.hardplugin;

import cn.catver.plugins.hardplugin.recipe.FlintKnifeRecipe;
import cn.catver.plugins.hardplugin.recipe.FlintPickaxeRecipe;
import cn.catver.plugins.hardplugin.recipe.GravelToFlintRecipe;
import cn.catver.plugins.hardplugin.recipe.StickRecipe;
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
