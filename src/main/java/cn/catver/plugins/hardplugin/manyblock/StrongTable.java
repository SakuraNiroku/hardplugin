package cn.catver.plugins.hardplugin.manyblock;

import cn.catver.plugins.hardplugin.Hardplugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrongTable {
    public static HashMap<String, ShapedRecipe> recipeHashMap = new HashMap<>();
    public static HashMap<String,ArrayList<ItemStack>> newRecipeHashMap = new HashMap<>();
    public static void addToHashMap(String s,ShapedRecipe r){
        recipeHashMap.put(s,r);

        {
            ArrayList<ItemStack> tables = new ArrayList<>();
            Map<Character, RecipeChoice> choiceMap = r.getChoiceMap();
            String[] recTable = r.getShape();
            for(int i = 0 ; i < 3 ; i++){
                byte[] bytes = recTable[i].getBytes();
                for(int y = 0; y < 3; y++){
                    byte b = bytes[y];
                    if(b != ' '){
                        RecipeChoice.ExactChoice choice = (RecipeChoice.ExactChoice) choiceMap.get(b);
                        tables.add(choice.getItemStack());
                    }else{
                        tables.add(new ItemStack(Material.AIR));
                    }
                }
            }
            newRecipeHashMap.put(s,tables);
        }


        Hardplugin.getIns().getLogger().info(String.format("%s配方加载完成！", s));

    }
    public static void playerhit(PlayerInteractEvent e){
        if(e.hasBlock() && e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CRAFTING_TABLE){
            if(e.getClickedBlock().getLocation().add(0,1,0).getBlock().getType() == Material.CHEST){
                if(e.getClickedBlock().getLocation().add(0,-1,0).getBlock().getType() == Material.RAW_COPPER_BLOCK){
                    func(e);
                }
            }
        }
    }

    public static void func(PlayerInteractEvent e){
        Chest chest = (Chest) e.getClickedBlock().getState();
        ArrayList<ItemStack> items = new ArrayList<>();
        ArrayList<ItemStack> needItems = new ArrayList<>();

        Inventory cinv = chest.getBlockInventory();
        items.add(cinv.getItem(0));
        items.add(cinv.getItem(1));
        items.add(cinv.getItem(2));
        items.add(cinv.getItem(9));
        items.add(cinv.getItem(10));
        items.add(cinv.getItem(11));
        items.add(cinv.getItem(18));
        items.add(cinv.getItem(19));
        items.add(cinv.getItem(20));

        ItemStack outputItem = new ItemStack(Material.AIR);
        ShapedRecipe okRecipe = null;

        {
            for (Map.Entry<String, ArrayList<ItemStack>> entry : newRecipeHashMap.entrySet()) {
                for(int a = 0;a<9;a++){
                    if (entry.getValue().get(a).getType() != Material.AIR) {
                        if(!ItemStackIf(entry.getValue().get(a), items.get(a))) continue; //配方错误
                        needItems.add(items.get(a).clone());
                    }else{
                        if(items.get(a).getType() != Material.AIR){
                            continue; //配方错误
                        }
                        needItems.add(new ItemStack(Material.AIR));
                    }
                }
                //配方正确awa
                okRecipe = recipeHashMap.get(entry.getKey());
                outputItem = okRecipe.getResult().clone();
                break;
            }
        }

        if(okRecipe != null){
            for (ItemStack item : needItems) {
                chest.getBlockInventory().removeItem(item);
            }
            chest.getBlockInventory().addItem(outputItem);

            e.getPlayer().sendMessage(ChatColor.GREEN+"咚咚咚，造好了");
        }else{
            e.getPlayer().sendMessage(ChatColor.RED+"配方错误！");
        }


    }

    public static boolean ItemStackIf(ItemStack a,ItemStack b){
        String nameA = a.getItemMeta().getDisplayName();
        String nameB = b.getItemMeta().getDisplayName();
        if(!nameA.equals(nameB)) return false; //名字不一致

        List<String> loreA = a.getItemMeta().getLore();
        List<String> loreB = b.getItemMeta().getLore();
        if(loreA.size() != loreB.size()) return false; //长度不一致
        for (int i = 0; i < loreA.size(); i++) {
            if(!loreA.get(i).equals(loreB.get(i))){
                return false; //内容不一致
            }
        }
        return true;
    }
}
