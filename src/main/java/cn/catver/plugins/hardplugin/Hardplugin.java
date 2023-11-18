package cn.catver.plugins.hardplugin;

import cn.catver.plugins.hardplugin.rule.NoVanillaCraft.NoVanillaCraft;
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

        logger.info("尝试导入物品");
        ItemRegister.init();

        logger.info("尝试导入配方");
        recipeRegister = new RecipeRegister(this);


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
