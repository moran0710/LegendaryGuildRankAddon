package top.molab.minecraft.legendaryGuildRankAddon.utils;

import com.legendaryrealms.LegendaryGuild.Data.Guild.Guild;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class PlayerUtils {
    public static int getPlayerGuildRank(OfflinePlayer player, String RankType){
        List<Guild> guilds = GuildUtils.sortGuilds(RankType);
        for (Guild guild : guilds){
            if (guild.getMembers().contains(player.getName())){
                return guilds.indexOf(guild)+1;
            }
        }
        return -1;
    }
}
