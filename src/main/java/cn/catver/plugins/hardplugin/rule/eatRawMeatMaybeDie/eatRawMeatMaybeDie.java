package cn.catver.plugins.hardplugin.rule.eatRawMeatMaybeDie;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class eatRawMeatMaybeDie implements Listener {
    public Material[] rawMeats = new Material[]{
            Material.BEEF,
            Material.CHICKEN,
            Material.MUTTON,
            Material.PORKCHOP
    };
    @EventHandler
    public void playereatingfunc(PlayerItemConsumeEvent event){
        for (Material meat : rawMeats) {
            if(event.getItem().getType() == meat){
                event.getPlayer().sendMessage(ChatColor.RED+"你怎么能吃生的食物！");
                int health = (int) event.getPlayer().getHealth();
                if(health % 2 == 0){
                    event.getPlayer().damage(health+10);
                }else{
                    event.getPlayer().damage(2);
                }
                break;
            }
        }
    }
}
