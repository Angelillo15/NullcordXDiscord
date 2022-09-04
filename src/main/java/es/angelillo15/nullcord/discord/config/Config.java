package es.angelillo15.nullcord.discord.config;

public class Config {
    private static final ConfigManager config = ConfigLoader.getConfig();

    public static String getActivityText(){
        return config.getConfig().getString("Config.onlineActivityText");
    }
    public static String getActivity(){
        return config.getConfig().getString("Config.onlineActivity");
    }
    public static String getStatus(){
        return config.getConfig().getString("Config.onlineStatus");
    }
    public static String getChannelID(){
        return config.getConfig().getString("Config.channelID");
    }
    public static String guild(){
        return config.getConfig().getString("Config.guild");
    }
    public static String defaultColor(){
        return config.getConfig().getString("Embed.color");
    }
    public static String onBotAttackTittle(){
        return config.getConfig().getString("Embed.onBotAttack.tittle");
    }
    public static String onBotAttackDescription(){
        return config.getConfig().getString("Embed.onBotAttack.description");
    }
    public static String onBotAttackFooter(){
        return config.getConfig().getString("Embed.onBotAttack.footer");
    }
    public static String onPingAttackTittle(){
        return config.getConfig().getString("Embed.onPingAttack.tittle");
    }
    public static String onPingAttackDescription(){
        return config.getConfig().getString("Embed.onPingAttack.description");
    }
    public static String onPingAttackFooter(){
        return config.getConfig().getString("Embed.onPingAttack.footer");
    }


}
