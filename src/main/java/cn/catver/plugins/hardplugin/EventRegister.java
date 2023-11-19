package cn.catver.plugins.hardplugin;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EventRegister {
    Map<String, Listener> events = new HashMap<>();
    public EventRegister(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();

        { //读取并解析 events.json
            try{
                String eventsjsonstr;
                { //读
                    BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("data/events.json")));
                    StringBuilder sb = new StringBuilder();
                    String t;
                    while ((t = br.readLine()) != null) sb.append(t);
                    eventsjsonstr = sb.toString();
                }
                { //解析
                    JsonArray root = JsonParser.parseString(eventsjsonstr).getAsJsonArray();
                    for (JsonElement element : root) {
                        String value = element.getAsString();
                        logger.info(String.format("加载%s事件中", value));
                        events.put(value, (Listener) Class.forName(value).newInstance());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                logger.severe("事件加载失败！服务器停止！");
                Bukkit.shutdown();
            }
        }

        logger.info("正在导入事件！");
        for (Map.Entry<String, Listener> entry : events.entrySet()) {
            Bukkit.getPluginManager().registerEvents(entry.getValue(),hardplugin);
            logger.info(String.format("%s事件导入完成！", entry.getKey()));

        }
        logger.info("所有事件导入完成");
    }
}
