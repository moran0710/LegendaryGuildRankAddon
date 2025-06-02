package top.molab.minecraft.legendaryGuildRankAddon.papiHolders;

import org.bukkit.OfflinePlayer;
import top.molab.minecraft.legendaryGuildRankAddon.BaseHolder;
import top.molab.minecraft.legendaryGuildRankAddon.utils.GuildUtils;

import java.math.BigDecimal;

public class ServerTotalMoneyHolder extends BaseHolder {

    @Override
    public String Parse(OfflinePlayer player, String[] args) {
        if (args[0].equals("ServerTotalMoney")){
            return BigDecimal.valueOf(GuildUtils.getServerTotalMoney()).toPlainString();
        }
        return null;
    }
}
