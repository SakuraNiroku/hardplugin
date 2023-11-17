package cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar;

import cn.catver.plugins.hardplugin.Hardplugin;
import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadableItemNBT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Function;

public class DurableDisplayManager {
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

    public static void updateBossBar(Player player,ItemStack itemStack){
        if(itemStack == null || itemStack.getAmount() == 0 || itemStack.getType() == Material.AIR) {
            DurableDisplayManager.getBossBarFromPlayer(player).removePlayer(player);
            return;
        }
        String isItTool = NBT.get(itemStack, (Function<ReadableItemNBT, String>) nbt-> nbt.getString("isItTool"));
        if(isItTool != null && isItTool.equalsIgnoreCase("yes")){
            KeyedBossBar bossBar = DurableDisplayManager.getBossBarFromPlayer(player);
            bossBar.addPlayer(player);
            int durable = NBT.get(itemStack, (Function<ReadableItemNBT, Integer>) nbt->nbt.getInteger("durable_hardplugin"));
            if(durable >= 100){
                bossBar.setProgress(1d);
            }else {
                bossBar.setProgress(durable/100d);
            }
            DurableDisplayManager.setDurableToPlayerBossBar(player,durable);
        }else {
            DurableDisplayManager.getBossBarFromPlayer(player).removePlayer(player);
        }
    }

//    public static void updateBossBar(Player player,int durable){
//        KeyedBossBar bossBar = DurableDisplayManager.getBossBarFromPlayer(player);
//        bossBar.addPlayer(player);
//        if(durable >= 50){
//            bossBar.setProgress(1d);
//        }else {
//            bossBar.setProgress(durable/50d);
//        }
//        DurableDisplayManager.setDurableToPlayerBossBar(player,durable);
//    }
}
