package cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class DurableBossBarManager {
    public static void createABossBarForPlayer(Player player){
        NamespacedKey key = new NamespacedKey(Hardplugin.getIns(), String.format("%s_%s", player.getName(),"durable_display"));
        Bukkit.createBossBar(
                key,
                ChatColor.GREEN+"工具耐久：",
                BarColor.PINK,
                BarStyle.SOLID
        );
    }

    public static KeyedBossBar getBossBarFromPlayer(Player player){
        return Bukkit.getBossBar(new NamespacedKey(Hardplugin.getIns(),String.format("%s_%s", player.getName(),"durable_display")));
    }

    public static void removeABossBarForPlayer(Player player){
        Bukkit.removeBossBar(new NamespacedKey(Hardplugin.getIns(),String.format("%s_%s", player.getName(),"durable_display")));
    }

    public static void setDurableToPlayerBossBar(Player player,int d){
        getBossBarFromPlayer(player).setTitle(ChatColor.GREEN+ String.format("工具耐久：%d", d));
    }
}
