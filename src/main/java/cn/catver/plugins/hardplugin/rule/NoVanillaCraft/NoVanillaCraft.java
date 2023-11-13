package cn.catver.plugins.hardplugin.rule.NoVanillaCraft;

import org.bukkit.Bukkit;

public class NoVanillaCraft {
    public static void init(){
        Bukkit.clearRecipes();
    }

    public static void unload(){
        Bukkit.resetRecipes();
    }
}
