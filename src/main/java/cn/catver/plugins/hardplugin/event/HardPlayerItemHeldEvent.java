package cn.catver.plugins.hardplugin.event;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadableItemNBT;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.function.Function;

public class HardPlayerItemHeldEvent implements Listener {
    @EventHandler
    public void effect_player_mining_fatigue(PlayerItemHeldEvent e){
        ItemStack itemStack;
        itemStack = e.getPlayer().getInventory().getItem(e.getNewSlot());
        if(itemStack != null && !itemStack.getType().isAir()){
            boolean tool = NBT.get(itemStack, (Function<ReadableItemNBT, Boolean>) nbt -> nbt.getBoolean("isItTool"));
            if(!tool){
                e.getPlayer().addPotionEffect(new PotionEffect(
                        PotionEffectType.SLOW_DIGGING,
                        -1,
                        1
                ));
            }else{
                e.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
            }
        }
    }
}
