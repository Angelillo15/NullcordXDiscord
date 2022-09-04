package es.angelillo15.nullcord.discord.config;

import es.angelillo15.nullcord.discord.NullcordDiscordBungeeManager;

public class ConfigLoader {
    private NullcordDiscordBungeeManager plugin;
    private static ConfigManager config;

    public ConfigLoader(NullcordDiscordBungeeManager plugin){
        this.plugin = plugin;
    }

    public void load(){
        loadConfig();
    }

    void loadConfig(){
        config = new ConfigManager(plugin.getDataFolder().toPath(), "config.yml", "config.yml");
        config.registerConfig();
    }

    public static ConfigManager getConfig(){
        return config;
    }
}
