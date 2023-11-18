package cn.catver.plugins.hardplugin;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RecipeRegister {
    HashMap<String, Recipe> recipes = new HashMap<>();

    public RecipeRegister(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();
        logger.info("开始导入配方");


        try{
            String recipesstrjson;
            { //读取recipes.json
                StringBuilder sb = new StringBuilder();
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("data/recipes.json")));

                while ((line = br.readLine()) != null){
                    sb.append(line);
                }
                recipesstrjson = sb.toString();
            }
            JsonArray recipesjson;
            { //解析json
                recipesjson = JsonParser.parseString(recipesstrjson).getAsJsonArray();
            }

            //TODO 加载
            {
                for (JsonElement element : recipesjson) {
                    JsonObject recipe = element.getAsJsonObject();
                    NamespacedKey key = new NamespacedKey(Hardplugin.getIns(),recipe.get("id").getAsString());
                    String type = recipe.get("type").getAsString();
                    Recipe r = null;
                    if(type.equalsIgnoreCase("campfire")){


                        int xp = recipe.get("xp").getAsInt();
                        int cooktime = recipe.get("cooktime").getAsInt();
                        RecipeChoice rc;
                        { //查找输入的物品
                            if(recipe.get("input").getAsJsonObject().get("material") == null){
                                //id存在
                                rc = new RecipeChoice.ExactChoice(
                                        ItemRegister.getItem(
                                                recipe.get("input").getAsJsonObject().get("id").getAsString()
                                        )
                                );
                            }else{
                                //material存在
                                rc = new RecipeChoice.ExactChoice(
                                        new ItemStack(Material.getMaterial(
                                                recipe.get("input").getAsJsonObject().get("material").getAsString()
                                        ))
                                );
                            }
                        }
                        ItemStack itemStack;
                        { //查找输出的物品
                            if(recipe.get("output").getAsJsonObject().get("material") == null){
                                //id存在
                                itemStack = ItemRegister.getItem(
                                        recipe.get("output").getAsJsonObject().get("id").getAsString()
                                );
                            }else{
                                //material存在
                                itemStack = new ItemStack(Material.getMaterial(
                                        recipe.get("output").getAsJsonObject().get("material").getAsString()
                                ));
                            }
                        }

                        r = new CampfireRecipe(
                                key,itemStack,rc,xp,cooktime
                        );


                    } else if (type.equalsIgnoreCase("furnace")) {


                        int xp = recipe.get("xp").getAsInt();
                        int cooktime = recipe.get("cooktime").getAsInt();
                        RecipeChoice rc;
                        { //查找输入的物品
                            if(recipe.get("input").getAsJsonObject().get("material") == null){
                                //id存在
                                rc = new RecipeChoice.ExactChoice(
                                        ItemRegister.getItem(
                                                recipe.get("input").getAsJsonObject().get("id").getAsString()
                                        )
                                );
                            }else{
                                //material存在
                                rc = new RecipeChoice.ExactChoice(
                                        new ItemStack(Material.getMaterial(
                                                recipe.get("input").getAsJsonObject().get("material").getAsString()
                                        ))
                                );
                            }
                        }
                        ItemStack itemStack;
                        { //查找输出的物品
                            if(recipe.get("output").getAsJsonObject().get("material") == null){
                                //id存在
                                itemStack = ItemRegister.getItem(
                                        recipe.get("output").getAsJsonObject().get("id").getAsString()
                                );
                            }else{
                                //material存在
                                itemStack = new ItemStack(Material.getMaterial(
                                        recipe.get("output").getAsJsonObject().get("material").getAsString()
                                ));
                            }
                        }

                        r = new FurnaceRecipe(
                                key,itemStack,rc,xp,cooktime
                        );


                    } else if (type.equalsIgnoreCase("shaped")) {


                        String s1;
                        String s2;
                        String s3;
                        HashMap<Character,RecipeChoice> rcmap = new HashMap<>();
                        ItemStack itemStack;
                        { //查找输出的物品
                            //logger.info(key.getKey());
                            if(recipe.get("output").getAsJsonObject().get("material") == null){
                                //id存在
                                itemStack = ItemRegister.getItem(
                                        recipe.get("output").getAsJsonObject().get("id").getAsString()
                                );
                            }else{
                                //material存在
                                itemStack = new ItemStack(Material.getMaterial(
                                        recipe.get("output").getAsJsonObject().get("material").getAsString()
                                ));
                            }
                            itemStack.setAmount(recipe.get("output").getAsJsonObject().get("count").getAsInt());
                        }
                        { //解析shaped数组
                            JsonArray shaped = recipe.get("shaped").getAsJsonArray();
                            s1 = shaped.get(0).getAsString();
                            s2 = shaped.get(1).getAsString();
                            s3 = shaped.get(2).getAsString();
                        }
                        { //解析input
                            JsonObject input = recipe.get("input").getAsJsonObject();
                            for (Map.Entry<String, JsonElement> entry : input.entrySet()) {
                                JsonObject e = entry.getValue().getAsJsonObject();
                                RecipeChoice prc;
                                if(e.get("material") != null){
                                    //material
                                    prc = new RecipeChoice.ExactChoice(
                                            new ItemStack(Material.getMaterial(e.get("material").getAsString()))
                                    );
                                }else{
                                    //id
                                    prc = new RecipeChoice.ExactChoice(
                                            ItemRegister.getItem(e.get("id").getAsString())
                                    );
                                }
                                rcmap.put(entry.getKey().toCharArray()[0],prc);
                            }
                        }
                        ShapedRecipe shapedRecipe = new ShapedRecipe(
                                key,itemStack
                        );
                        shapedRecipe.shape(s1,s2,s3);
                        for (Map.Entry<Character, RecipeChoice> entry : rcmap.entrySet()) {
                            shapedRecipe.setIngredient(entry.getKey(),entry.getValue());
                        }
                        r = shapedRecipe;


                    } else if (type.equalsIgnoreCase("shapeless")) {


                        ArrayList<RecipeChoice> rclist = new ArrayList<>();
                        ItemStack itemStack;
                        { //查找输出的物品
                            if(recipe.get("output").getAsJsonObject().get("material") == null){
                                //id存在
                                itemStack = ItemRegister.getItem(
                                        recipe.get("output").getAsJsonObject().get("id").getAsString()
                                );
                            }else{
                                //material存在
                                itemStack = new ItemStack(Material.getMaterial(
                                        recipe.get("output").getAsJsonObject().get("material").getAsString()
                                ));
                            }
                            itemStack.setAmount(recipe.get("output").getAsJsonObject().get("count").getAsInt());
                        }
                        { //解析input
                            JsonArray input = recipe.get("input").getAsJsonArray();
                            for (JsonElement jsonElement : input) {
                                JsonObject object = jsonElement.getAsJsonObject();
                                if(object.get("material") != null){
                                    //material
                                    rclist.add(new RecipeChoice.ExactChoice(new ItemStack(
                                            Material.getMaterial(object.get("material").getAsString())
                                    )));
                                }else{
                                    //id
                                    rclist.add(new RecipeChoice.ExactChoice(
                                            ItemRegister.getItem(object.get("id").getAsString())
                                    ));
                                }
                            }
                        }
                        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(
                                key,itemStack
                        );
                        for (RecipeChoice choice : rclist) {
                            shapelessRecipe.addIngredient(choice);
                        }
                        r = shapelessRecipe;


                    }
                    recipes.put(recipe.get("id").getAsString(),r);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
            logger.severe("配方导入失败！服务器停止！");
            Bukkit.shutdown();
        }


        for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {
            Bukkit.addRecipe(entry.getValue());
            logger.info(String.format("%s配方已导入完成！", entry.getKey()));
        }
        logger.info("配方导入完成！");

    }

    public void unload(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();

        logger.info("开始卸载配方");
        for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {
            Bukkit.removeRecipe(new NamespacedKey(hardplugin,entry.getKey()));
            logger.info(String.format("%s配方已卸载！", entry.getKey()));
        }
        logger.info("配方卸载完成！");
    }
}
