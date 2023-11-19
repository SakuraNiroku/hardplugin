package cn.catver.plugins.hardplugin.event;

import cn.catver.plugins.hardplugin.ItemRegister;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class HardPlayerInteractEvent implements Listener {
    @EventHandler
    public void playerhitblockfunc_coal(PlayerInteractEvent event){
        if(event.hasBlock()){
            if(event.getAction() == Action.LEFT_CLICK_BLOCK){
                if(event.getClickedBlock().getType() == Material.CRAFTING_TABLE){
                    Location craft = event.getClickedBlock().getLocation();
                    {
                        Location[] locations = new Location[]{
                                new Location(craft.getWorld(),craft.getX()+1,craft.getY(),craft.getZ()),
                                new Location(craft.getWorld(),craft.getX()-1,craft.getY(),craft.getZ()),
                                new Location(craft.getWorld(),craft.getX(),craft.getY(),craft.getZ()-1),
                                new Location(craft.getWorld(),craft.getX(),craft.getY(),craft.getZ()+1)
                        };

                        for (Location loc : locations) {
                            if(loc.getBlock().getType() != Material.COAL_BLOCK){
                                return;
                            }
                        }
                    }
                    event.getPlayer().getInventory().addItem(ItemRegister.getItem("coalcrafttablecore"));
                    event.getPlayer().sendMessage(ChatColor.GREEN+"你获得了一个煤炭工作台核心！");
                }
            }
        }
    }

    @EventHandler
    public void playerhitblockfunc_rawcopper(PlayerInteractEvent event){
        if(event.hasBlock()){
            if(event.getAction() == Action.LEFT_CLICK_BLOCK){
                if(event.getClickedBlock().getType() == Material.CRAFTING_TABLE){
                    Location craft = event.getClickedBlock().getLocation();
                    {
                        Location[] locations = new Location[]{
                                new Location(craft.getWorld(),craft.getX()+1,craft.getY(),craft.getZ()),
                                new Location(craft.getWorld(),craft.getX()-1,craft.getY(),craft.getZ()),
                                new Location(craft.getWorld(),craft.getX(),craft.getY(),craft.getZ()-1),
                                new Location(craft.getWorld(),craft.getX(),craft.getY(),craft.getZ()+1)
                        };

                        for (Location loc : locations) {
                            if(loc.getBlock().getType() != Material.RAW_COPPER_BLOCK){
                                return;
                            }
                        }
                    }
                    event.getPlayer().getInventory().addItem(ItemRegister.getItem("rawcoppercrafttablecore"));
                    event.getPlayer().sendMessage(ChatColor.GREEN+"你获得了一个粗铜工作台核心！");
                }
            }
        }
    }

}
