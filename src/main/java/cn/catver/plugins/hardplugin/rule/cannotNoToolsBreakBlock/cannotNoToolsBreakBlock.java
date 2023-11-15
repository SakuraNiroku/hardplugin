package cn.catver.plugins.hardplugin.rule.cannotNoToolsBreakBlock;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadableItemNBT;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class cannotNoToolsBreakBlock implements Listener {
    @EventHandler
    public void playerbreakblockfunc(BlockBreakEvent e){
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR){
            String isItTool = NBT.get(e.getPlayer().getInventory().getItemInMainHand(),
                    (Function<ReadableItemNBT, String>) nbt -> nbt.getString("isItTool"));
            if(isItTool != null){
                if(!isItTool.equalsIgnoreCase("yes")){
                    e.getPlayer().damage(6);
                }else{
                    int slot = e.getPlayer().getInventory().getHeldItemSlot();
                    ItemStack itemStack = e.getPlayer().getInventory().getItem(slot);
                    int durable = NBT.get(itemStack, (Function<ReadableItemNBT, Integer>) nbt->nbt.getInteger("durable_hardplugin"));
                    durable = durable - 1;

                    if(durable != 0){
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        List<String> lore = new ArrayList<>();
                        lore.add(String.format("耐久：%d", durable));
                        itemMeta.setLore(lore);
                        itemMeta.setUnbreakable(true);
                        itemStack.setItemMeta(itemMeta);

                        int finalDurable = durable;
                        NBT.modify(itemStack, nbt->{
                            nbt.setString("isItTool","yes");
                            nbt.setInteger("durable_hardplugin", finalDurable);
                        });
                        //e.getPlayer().getInventory().addItem(itemStack);
                        e.getPlayer().getInventory().setItem(slot,itemStack);
                        e.getPlayer().sendMessage(ChatColor.GREEN+ String.format("你的工具剩余%d点耐久", durable));
                    }else{
                        e.getPlayer().getInventory().setItem(slot,new ItemStack(Material.AIR));
                        e.getPlayer().sendMessage(ChatColor.RED+"你的工具炸了！");
                    }
                }
            }else {
                e.getPlayer().damage(6);
            }
        }else{
            e.getPlayer().damage(6);
        }
    }
}
