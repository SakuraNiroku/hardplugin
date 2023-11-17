package cn.catver.plugins.hardplugin;

import cn.catver.plugins.hardplugin.rule.clickCoalCraftTableToGiveACore.clickCoalCraftTableToGiveACore;
import cn.catver.plugins.hardplugin.rule.cannotNoToolsBreakBlock.cannotNoToolsBreakBlock;
import cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar.DurableDisplayPlayerHeldItemEvent;
import cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar.DurableDisplayPlayerJoinEvent;
import cn.catver.plugins.hardplugin.rule.displayToolDurableFromBassBar.DurableDisplayPlayerLeftEvent;
import cn.catver.plugins.hardplugin.rule.eatRawMeatMaybeDie.eatRawMeatMaybeDie;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EventRegister {
    Map<String, Listener> events = new HashMap<>();
    public EventRegister(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();

        //TODO 写在这里
        events.put("cannotNoToolsBreakBlock",new cannotNoToolsBreakBlock());

        events.put("eatRawMeatMaybeDie",new eatRawMeatMaybeDie());

        events.put("clickCoalCraftTableToGiveACore",new clickCoalCraftTableToGiveACore());

        events.put("displayToolDurableFromBossBar1",new DurableDisplayPlayerJoinEvent());
        events.put("displayToolDurableFromBossBar2",new DurableDisplayPlayerLeftEvent());
        events.put("displayToolDurableFromBossBar3",new DurableDisplayPlayerHeldItemEvent());

        logger.info("正在导入事件！");
        for (Map.Entry<String, Listener> entry : events.entrySet()) {
            Bukkit.getPluginManager().registerEvents(entry.getValue(),hardplugin);
            logger.info(String.format("%s事件导入完成！", entry.getKey()));

        }
        logger.info("所有事件导入完成");
    }
}
