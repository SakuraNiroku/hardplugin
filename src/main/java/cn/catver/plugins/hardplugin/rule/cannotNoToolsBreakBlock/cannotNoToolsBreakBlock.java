package cn.catver.plugins.hardplugin.rule.cannotNoToolsBreakBlock;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadableItemNBT;
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
                    ItemStack itemStack = e.getPlayer().getInventory().getItemInMainHand();
                    itemStack.setAmount(1);
                    int durable = NBT.get(itemStack, (Function<ReadableItemNBT, Integer>) nbt->nbt.getInteger("durable_hardplugin"));
                    durable = durable - 1;
                    e.getPlayer().getInventory().remove(itemStack);
                    if(durable != 0){
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        List<String> lore = new ArrayList<>();
                        lore.add(String.format("耐久：%d", durable));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);

                        int finalDurable = durable;
                        NBT.modify(itemStack, nbt->{
                            nbt.setString("isItTool","yes");
                            nbt.setInteger("durable_hardplugin", finalDurable);
                        });
                        e.getPlayer().getInventory().addItem(itemStack);
                    }
                }
            }else {
                e.getPlayer().damage(6);
            }
        }
    }
}
