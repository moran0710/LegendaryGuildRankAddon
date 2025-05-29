# LegendaryGuildRankAddon

这是一个非常建议的PlaceHolderAPI拓展，用于拓展[LegendaryGuild](https://www.minebbs.com/threads/legendaryguild.24223/)的Papi变量

写这玩意的原因是，LegendaryGuild的PAPI变量有点不够我用，我又不太想动本体。

**注意：这是个PlaceholderAPI拓展，所以不要把他安装在插件文件夹，而是`plugins/PlaceholderAPI/expansions/`文件夹下！！** 

**你需要先安装PlaceholderAPI和LegendaryGuild**

## 拓展的Placeholder APIs

### RankType参数

| RankType  | 说明     |
|-----------|--------|
| Money     | 公会银行资产 |
| Member    | 公会成员数量 |
| Level     | 公会等级   |
| TreeLevel | 公会神树等级 |
| Activity  | 公会活跃度  |

### PlaceholderAPI变量表

| 变量                                          | 返回值类型 | 说明               | 参数                              | 例子                                                        |
|---------------------------------------------|-------|------------------|---------------------------------|-----------------------------------------------------------|
| LGRAddon_Rank_{RankType}_{Rank}_Value       | float | 获取指定公会排行榜的指定类型的值 | RankType: 排行类型, Rank: 排名        | LGRAddon_Money_1_Value：获取公会银行排名第一的公会银行余额                  |
| LGRAddon_Player_{RankType}_Rank             | int   | 获取此玩家所在公会某项排名    | RankType: 排行类型                  | LGAddon_Player_Money_Rank：获取此玩家所在公会的公会银行余额排名              |
| LGRAddon_Other_{PlayerName}_{RankType}_Rank | int   | 获取指定玩家所在公会的某项排名  | RankType: 排行类型, PlayerName: 玩家名 | LGRAddon_Other_moran0710_Money_Rank：获取moran0710所在公会银行余额排名 |

## 变量不够用？

### 1. 提Issue

你可以在本项目的Issue建议你想加入的与LegendaryGuild有关的PAPI变量

由于写起来不难所以基本没事就会帮你实现一下

### 2. 自行拓展

你需要先了解PlaceholderAPI拓展开发的一些概念，[PlaceHolderAPI开发者文档](https://wiki.placeholderapi.com/developers/creating-a-placeholderexpansion/)

1. Clone本仓库
2. 在`top.molab.minecraft.legendaryGuildRankAddon.papiHolders`包下新建一个类，继承`top.molab.minecraft.legendaryGuildRankAddon.BaseHolder`
3. 重写`Parse(OfflinePlayer player, String[] args)`方法
4. 在主类`LGRAExpansion`的无参构造方法内，调用`LGRAExpansion.registerHolder(BaseHolder holder)`注册你的新处理器
5. 发起PR（如果愿意）

你可以参考我写的这些处理器

## PAPI ECloud相关

上传不了，不开放注册了，不想弄（

## 许可证

MIT