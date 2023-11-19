package cn.catver.plugins.hardplugin.manyblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LogFurnace {
    public static void playerhitblockfunc(PlayerInteractEvent e){
        if(e.hasBlock() && e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.CRAFTING_TABLE){
            Location table = e.getClickedBlock().getLocation();

            if(table.clone().add(0,1,0).getBlock().getType() == Material.CHEST){
                if(table.clone().add(0,-1,0).getBlock().getType() == Material.FURNACE){
                    if
                    (
                            (
                                table.clone().add(-1,1,0).getBlock().getType() == Material.COBBLESTONE &&
                                table.clone().add(-1,-1,0).getBlock().getType() == Material.COBBLESTONE &&
                                table.clone().add(1,-1,0).getBlock().getType() == Material.COBBLESTONE &&
                                table.clone().add(1,1,0).getBlock().getType() == Material.COBBLESTONE
                            ) ||
                            (
                                table.clone().add(0,1,-1).getBlock().getType() == Material.COBBLESTONE &&
                                table.clone().add(0,-1,-1).getBlock().getType() == Material.COBBLESTONE &&
                                table.clone().add(0,-1,1).getBlock().getType() == Material.COBBLESTONE &&
                                table.clone().add(0,1,1).getBlock().getType() == Material.COBBLESTONE
                            )
                    ){
                        if
                        (
                            (
                                table.clone().add(-1,0,0).getBlock().getType() == Material.COAL_BLOCK &&
                                table.clone().add(1,0,0).getBlock().getType() == Material.COAL_BLOCK
                            )||
                            (
                                table.clone().add(0,0,1).getBlock().getType() == Material.COAL_BLOCK &&
                                table.clone().add(0,0,-1).getBlock().getType() == Material.COAL_BLOCK
                            )
                        ){
                            Chest chest = (Chest) table.clone().add(0,1,0).getBlock().getState();
                            if(chest.getBlockInventory().contains(Material.OAK_LOG,18)){
                                chest.getBlockInventory().removeItem(new ItemStack(Material.OAK_LOG,18));
                                chest.getBlockInventory().addItem(new ItemStack(Material.COAL,18));
                                e.getPlayer().sendMessage(ChatColor.GREEN+"炭烧好了");
                                if(new Random().nextBoolean()){
                                    if(new Random().nextBoolean()){
                                        if(new Random().nextBoolean()){
                                            if(table.clone().add(-1,0,0).getBlock().getType() == Material.COAL_BLOCK &&
                                                    table.clone().add(1,0,0).getBlock().getType() == Material.COAL_BLOCK){
                                                table.clone().add(-1,0,0).getBlock().setType(Material.AIR);
                                                table.clone().add(1,0,0).getBlock().setType(Material.AIR);
                                            }else{
                                                table.clone().add(0,0,1).getBlock().setType(Material.AIR);
                                                table.clone().add(0,0,-1).getBlock().setType(Material.AIR);
                                            }
                                        }
                                    }
                                }
                            }else{
                                e.getPlayer().sendMessage(ChatColor.RED+"需要18个原木");
                            }
                        }else{
                            e.getPlayer().getWorld().createExplosion(table.clone().add(0,-1,0),10,true);
                            e.getPlayer().sendMessage(ChatColor.RED+"燃料呢？");
                        }
                    }
                }
            }
        }
    }
}
