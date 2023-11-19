package cn.catver.plugins.hardplugin.event;

import cn.catver.plugins.hardplugin.ItemRegister;
import cn.catver.plugins.hardplugin.manyblock.CraftTableCore;
import cn.catver.plugins.hardplugin.manyblock.LogFurnace;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class HardPlayerInteractEvent implements Listener {
    @EventHandler
    public void func(PlayerInteractEvent e){
        CraftTableCore.playerhitblock(e); //工作台监听
        LogFurnace.playerhitblockfunc(e);
    }
}
