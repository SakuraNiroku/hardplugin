package cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class DurableDisplayPlayerLeftEvent implements Listener {
    @EventHandler
    public void playerleftfunc(PlayerQuitEvent event){
        DurableBossBarManager.removeABossBarForPlayer(event.getPlayer());
    }
}
