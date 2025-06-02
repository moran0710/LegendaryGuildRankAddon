package top.molab.minecraft.legendaryGuildRankAddon;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import top.molab.minecraft.legendaryGuildRankAddon.papiHolders.OtherPlayerHolder;
import top.molab.minecraft.legendaryGuildRankAddon.papiHolders.PlayerHolder;
import top.molab.minecraft.legendaryGuildRankAddon.papiHolders.RankHolder;
import top.molab.minecraft.legendaryGuildRankAddon.papiHolders.ServerTotalMoneyHolder;

import java.util.ArrayList;

public class LGRAExpansion extends PlaceholderExpansion {

    private final ArrayList<BaseHolder> holders = new ArrayList<BaseHolder>();

    public void registerHolder(BaseHolder holder){
        this.holders.add(holder);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "LGRAddon";
    }

    public LGRAExpansion(){
        registerHolder(new PlayerHolder());
        registerHolder(new RankHolder());
        registerHolder(new OtherPlayerHolder());
        registerHolder(new ServerTotalMoneyHolder());
    }

    @Override
    public @NotNull String getAuthor() {
        return "Moran0710";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(this.getRequiredPlugin()) != null;
    }

    @Override
    public @NotNull String getRequiredPlugin() {
        return "LegendaryGuild";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params){
        String[] paramsArray = params.split("_");
        for(BaseHolder holder : this.holders){
            String result = holder.Parse(player, paramsArray);
            if(result != null){
                return result;
            }
        }
        return null;
    }


}
