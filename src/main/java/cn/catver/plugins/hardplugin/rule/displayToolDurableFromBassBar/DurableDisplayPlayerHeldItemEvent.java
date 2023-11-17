package cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadableItemNBT;
import org.bukkit.ChatColor;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.function.Function;

public class DurableDisplayPlayerHeldItemEvent implements Listener {
    @EventHandler
    public void playerhelditemfunc(PlayerItemHeldEvent event){
        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();

        String isItTool = NBT.get(itemStack, (Function<ReadableItemNBT, String>) nbt-> nbt.getString("isItTool"));
        if(isItTool != null && isItTool.equalsIgnoreCase("yes")){
            KeyedBossBar bossBar = DurableBossBarManager.getBossBarFromPlayer(event.getPlayer());
            bossBar.addPlayer(event.getPlayer());
            int durable = NBT.get(itemStack, (Function<ReadableItemNBT, Integer>) nbt->nbt.getInteger("durable_hardplugin"));
            if(durable >= 50){
                bossBar.setProgress(1d);
            }else {
                bossBar.setProgress(durable/50d);
            }
            DurableBossBarManager.setDurableToPlayerBossBar(event.getPlayer(),durable);
        }else {
            DurableBossBarManager.getBossBarFromPlayer(event.getPlayer()).removePlayer(event.getPlayer());
        }
    }
}
