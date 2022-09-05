package es.angelillo15.nullcord.discord;

import es.angelillo15.nullcord.discord.cmd.MainCMD;
import es.angelillo15.nullcord.discord.config.Config;
import es.angelillo15.nullcord.discord.config.ConfigLoader;
import es.angelillo15.nullcord.discord.listeners.AttackDetected;
import es.angelillo15.nullcord.discord.listeners.OnReady;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import javax.security.auth.login.LoginException;
import java.util.logging.Logger;

public class NullcordDiscordBungeeManager extends Plugin {
    private ShardManager shardManager;
    private static Logger logger;
    public static TextChannel channel;

    public void setupLogger(){
        logger = getLogger();
    }

    public void registerEvent(){
        PluginManager pluginManager = getProxy().getPluginManager();
        pluginManager.registerListener(this , new AttackDetected());
        pluginManager.registerCommand(this, new MainCMD());

    }

    public void setupDiscordBot() throws LoginException {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(ConfigLoader.getConfig().getConfig().getString("Config.token"));
        builder.setStatus(OnlineStatus.valueOf(Config.getStatus()));
        builder.setActivity(Activity.of(Activity.ActivityType.valueOf(Config.getActivity()), Config.getActivityText()));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES);
        shardManager = builder.build();

        shardManager.addEventListener(new OnReady());
    }

    public void registerConfig(){
        ConfigLoader configLoader = new ConfigLoader(this);
        configLoader.load();
    }

    public static TextChannel getChannel() {
        return channel;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static Logger getPluginLogger(){
        return logger;
    }
}
