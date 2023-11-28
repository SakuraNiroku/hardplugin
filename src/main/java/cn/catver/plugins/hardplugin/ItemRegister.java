package cn.catver.plugins.hardplugin;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.*;

public class ItemRegister {
    private static HashMap<String, ItemStack> itemsmap = new HashMap<>();
    static {
        try{
            Hardplugin.getIns().logger.info("开始加载物品！");
            String itemfilestr;
            {
                StringBuilder sb = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        ItemRegister.class.getClassLoader().getResourceAsStream("data/items.json")));
                String line;
                while ((line = br.readLine()) != null){
                    sb.append(line);
                }
                itemfilestr = sb.toString();
            }
            JsonArray itemsjson;
            {
                itemsjson = JsonParser.parseString(itemfilestr).getAsJsonArray();
            }
            //TODO 加载
            for (JsonElement element : itemsjson) {
                JsonObject item = element.getAsJsonObject();
                Hardplugin.getIns().logger.info(String.format("加载%s物品中", item.get("id").getAsString()));
                //开始生成物品
                ItemStack itemStack;
                { //指定类型
                    itemStack = new ItemStack(
                            Objects.requireNonNull(Material.getMaterial(item.get("type").getAsString())));
                }
                { //设置名称
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',item.get("display").getAsString()));
                    itemStack.setItemMeta(itemMeta);
                }
                { //附魔添加
                    if (item.get("ench") != null){
                        JsonObject object = item.get("ench").getAsJsonObject();
                        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
                            int level = entry.getValue().getAsInt();
                            Enchantment enchantment = Enchantment.getByName(entry.getKey());
                            itemStack.addEnchantment(enchantment,level);
                        }
                    }
                }
                { //nbt

                }
                { //判断是否为工具
                    if(item.get("tool").getAsBoolean()){
                        { //nbt设置
                            int durable = item.get("durable").getAsInt();
                            NBT.modify(itemStack,nbt->{
                                //nbt.setString("isItTool","yes");
                                nbt.setBoolean("isItTool",true);
                                nbt.setInteger("Damage",itemStack.getType().getMaxDurability()-(itemStack.getType().getMaxDurability()-durable));
                            });
                        }
                    }
                }
                itemsmap.put(item.get("id").getAsString(),itemStack);
                //Hardplugin.getIns().logger.info(String.format("加载%s物品完成！", item.get("id").getAsString()));
            }
            Hardplugin.getIns().logger.info("物品加载完成！");
        }catch (Exception e){
            e.printStackTrace();
            Hardplugin.getIns().logger.severe("无法加载物品！服务器即将停止");
            Bukkit.shutdown();
        }
    }

    public static void init(){
        Hardplugin.getIns().logger.info("开始初始化物品！");
    }

    public static ItemStack getItem(String k){
        return itemsmap.containsKey(k) ? itemsmap.get(k).clone() : null;
    }
}
