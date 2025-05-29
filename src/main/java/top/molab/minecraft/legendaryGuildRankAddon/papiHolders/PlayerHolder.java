package top.molab.minecraft.legendaryGuildRankAddon.papiHolders;

import org.bukkit.OfflinePlayer;
import top.molab.minecraft.legendaryGuildRankAddon.BaseHolder;
import top.molab.minecraft.legendaryGuildRankAddon.utils.PlayerUtils;

public class PlayerHolder extends BaseHolder {

    @Override
    public String Parse(OfflinePlayer player, String[] args)
    {
        if (! args[0].equals("Player") || args.length < 3)
        {return null;}
        if (args.length >= 3 && args[2].equals("Rank")){
            return String.valueOf(
                    PlayerUtils.getPlayerGuildRank(player, args[1])
            );

        }return "无";
    }
}
