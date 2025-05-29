package top.molab.minecraft.legendaryGuildRankAddon;

import org.bukkit.OfflinePlayer;

/**
 *  用于快速添加Papi变量处理器的类
 */
public abstract class BaseHolder {

    /**
     * 处理Papi变量请求
     * 如果本处理器无法处理该请求，请返回null
     * 如果你不太能理解这里在做什么，请参阅PAPI文档：<a href="https://wiki.placeholderapi.com/developers/creating-a-placeholderexpansion/">...</a>
     * @param player 用于分析的玩家
     * @param args 参数列表，这里已经把PAPI传入的params分割成了数组
     *             用起来比较像Bukkit的CommandSender
     * @return 格式化好的PAPI变量，如果无法处理，返回null
     */
    public String Parse(OfflinePlayer player, String[] args){ return null; }

}
