package top.molab.minecraft.legendaryGuildRankAddon.papiHolders;

import com.legendaryrealms.LegendaryGuild.Data.Guild.Guild;
import org.bukkit.OfflinePlayer;
import top.molab.minecraft.legendaryGuildRankAddon.BaseHolder;
import java.util.List;
import top.molab.minecraft.legendaryGuildRankAddon.enums.RankTypes;
import top.molab.minecraft.legendaryGuildRankAddon.utils.GuildUtils;

public class RankHolder extends BaseHolder {

    @Override
    public String Parse(OfflinePlayer player, String[] args){
        if (!args[0].equals("Rank") || args.length < 3) return null;
        List<Guild> guilds = GuildUtils.sortGuilds(args[1]);
        if (args.length >= 4 && args[3].equals("Value")) {
            try {
                int index = Integer.parseInt(args[2]);
                return guilds.get(index - 1).getGuild();
            } catch (NumberFormatException ex) {
                return "你输入的索引不合法";
            } catch (IndexOutOfBoundsException ex) {
                return "无公会";
            }
        }return "";
    }
}
