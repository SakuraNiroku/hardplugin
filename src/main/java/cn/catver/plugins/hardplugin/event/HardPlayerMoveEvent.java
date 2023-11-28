package cn.catver.plugins.hardplugin.event;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HardPlayerMoveEvent implements Listener {
    @EventHandler
    public void give_player_effect(PlayerMoveEvent e){
        if(e.getTo() != null){
            Block block = e.getTo().getBlock();
            int skylight = block.getLightFromSky();
            int blocklight = block.getLightFromBlocks();


            if(skylight == 0 && (blocklight > 7 || e.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))){
                e.getPlayer().removePotionEffect(PotionEffectType.WEAKNESS);
                e.getPlayer().addPotionEffect(new PotionEffect(
                        PotionEffectType.REGENERATION,
                        -1,
                        1
                ));
            } else if (skylight == 0 && blocklight < 3) {
                e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
                e.getPlayer().addPotionEffect(new PotionEffect(
                        PotionEffectType.WEAKNESS,
                        -1,
                        1
                ));
            }

            if(skylight != 0){
                e.getPlayer().removePotionEffect(PotionEffectType.WEAKNESS);
                e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
            }


        }

    }
}
