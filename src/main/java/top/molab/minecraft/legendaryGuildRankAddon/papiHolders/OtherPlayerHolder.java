package top.molab.minecraft.legendaryGuildRankAddon.papiHolders;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import top.molab.minecraft.legendaryGuildRankAddon.BaseHolder;
import top.molab.minecraft.legendaryGuildRankAddon.utils.PlayerUtils;

public class OtherPlayerHolder extends BaseHolder {
    @Override
    public String Parse(OfflinePlayer player, String[] args)
    {
        if (! args[0].equals("Other") || args.length < 3)
        {return null;}
        if (args.length >= 3 && args[3].equals("Rank")){
            Player playerB = Bukkit.getPlayer(args[1]);
            if (playerB != null){
                return String.valueOf(
                        PlayerUtils.getPlayerGuildRank(playerB, args[2])
                );
            }

        }return "无";
    }
}
