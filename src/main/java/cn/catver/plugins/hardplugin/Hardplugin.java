package cn.catver.plugins.hardplugin;

import cn.catver.plugins.hardplugin.rule.NoVanillaCraft.NoVanillaCraft;
import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Hardplugin extends JavaPlugin {
    Logger logger = getLogger();
    RecipeRegister recipeRegister;
    private static Hardplugin Ins;
    @Override
    public void onEnable() {
        Ins = this;
        // Plugin startup logic

        //TODO NoVanillaCraft
        NoVanillaCraft.init();

        //TODO 导入配方
        logger.info("尝试导入配方");
        recipeRegister = new RecipeRegister(this);

//        {
//            ItemStack itemStack = new ItemStack(Material.FLINT);
//            ItemMeta imeta = itemStack.getItemMeta();
//            imeta.setDisplayName(ChatColor.GREEN+"燧石刀");
//            itemStack.setItemMeta(imeta);
//            NBT.modify(itemStack,nbt->{
//                nbt.setString("isItTool","yes");
//            });
//
//            ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this,"tool1"),itemStack);
//            recipe.shape("   "," b ","   ");
//            recipe = recipe.setIngredient('b',Material.DIRT);
//            //Bukkit.addRecipe(recipe);
//
//            ShapelessRecipe recipe1 = new ShapelessRecipe(new NamespacedKey(this,"tool2"),itemStack);
//            recipe1 = recipe1.addIngredient(Material.DIRT);
//            Bukkit.addRecipe(recipe1);
//        }

        logger.info("尝试导入事件");
        EventRegister eventRegister = new EventRegister(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //TODO 卸载配方
        recipeRegister.unload(this);
        //TODO 关闭NoVanillaCraft
        NoVanillaCraft.unload();

    }

    public static Hardplugin getIns() {
        return Ins;
    }
}
