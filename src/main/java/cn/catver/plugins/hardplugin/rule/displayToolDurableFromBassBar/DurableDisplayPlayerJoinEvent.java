package cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DurableDisplayPlayerJoinEvent implements Listener {
    @EventHandler
    public void playerjoinfunc(org.bukkit.event.player.PlayerJoinEvent event){
        DurableBossBarManager.createABossBarForPlayer(event.getPlayer());
    }
}
