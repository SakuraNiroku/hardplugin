package cn.catver.plugins.hardplugin.rule.cannotEmptyBreakBlock;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class cannotEmptyBreakBlock implements Listener {
    @EventHandler
    public void playerbreakfunc(BlockBreakEvent e){
        if(e.isCancelled()) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR){ //空手
            e.getPlayer().damage(6); // 给予2点伤害
        }
    }
}
