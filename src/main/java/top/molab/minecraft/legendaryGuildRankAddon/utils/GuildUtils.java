package top.molab.minecraft.legendaryGuildRankAddon.utils;

import com.legendaryrealms.LegendaryGuild.Data.Guild.Guild;
import com.legendaryrealms.LegendaryGuild.Data.Guild.GuildActivityData;
import com.legendaryrealms.LegendaryGuild.LegendaryGuild;
import com.legendaryrealms.LegendaryGuild.Menu.Panels.GuildListPanel;
import org.bukkit.Bukkit;
import top.molab.minecraft.legendaryGuildRankAddon.enums.RankTypes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuildUtils {


    public static List<Guild> sortGuilds(Comparator<Guild> comparator){
        List<Guild> guilds = getGuilds();
        guilds.sort(comparator);
        return guilds;
    }


    public static List<Guild> sortGuildsByMoney(){
        return sortGuilds(Comparator.comparingDouble(Guild::getMoney).reversed());
    }

    public static List<Guild> sortGuildsByLevel(){
        return sortGuilds(Comparator.comparingInt(Guild::getLevel).reversed());
    }

    public static List<Guild> sortGuildsByMember(){
        return sortGuilds(Comparator.comparingInt((guild) -> guild.getMembers().size())).reversed();
    }

    public static List<Guild> sortGuildsByTreeLevel(){
        return sortGuilds(Comparator.comparingDouble(Guild::getTreelevel).reversed());
    }

    public static List<Guild> sortGuilds(String rankType){
        switch (rankType){
            case RankTypes.ACTIVITY -> {
                return sortGuildsByActivity();
            }
            case RankTypes.LEVEL -> {
                return sortGuildsByLevel();
            }
            case RankTypes.MEMBER -> {
                return sortGuildsByMember();
            }
            case RankTypes.TREE_LEVEL -> {
                return sortGuildsByTreeLevel();
            }
            case RankTypes.MONEY -> {
                return sortGuildsByMoney();
            }
            default -> {
                return new ArrayList<>();
            }
        }
    }

    public static List<Guild> sortGuildsByActivity(){
        LegendaryGuild lg = LegendaryGuild.getInstance();
        if (lg != null) {
            return lg.getGuildsManager().getGuildsBy(GuildListPanel.Sort.ACTIVITY);
        }
        return new ArrayList<>();
    }

    public static List<Guild> getGuilds(){
        List<String> guildNames = LegendaryGuild.getInstance().getGuildsManager().getGuilds();
        return guildNames.stream().map(guildName -> LegendaryGuild.getInstance().getGuildsManager().getGuild(guildName)).collect(Collectors.toList());
    }
}
