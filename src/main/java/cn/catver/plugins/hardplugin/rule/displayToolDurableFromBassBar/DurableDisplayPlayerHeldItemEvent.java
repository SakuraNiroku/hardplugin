package cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadableItemNBT;
import org.bukkit.Material;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Function;

public class DurableDisplayPlayerHeldItemEvent implements Listener {
    @EventHandler
    public void playerhelditemfunc(PlayerItemHeldEvent event){
        ItemStack itemStack = event.getPlayer().getInventory().getItem(event.getNewSlot());
        DurableDisplayManager.updateBossBar(event.getPlayer(),itemStack);
    }
}
