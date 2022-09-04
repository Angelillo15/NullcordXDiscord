package es.angelillo15.nullcord.discord.listeners;

import es.angelillo15.nullcord.discord.NullcordDiscordBungeeManager;
import es.angelillo15.nullcord.discord.config.Config;
import es.angelillo15.nullcord.discord.utils.Utils;
import net.dv8tion.jda.api.entities.TextChannel;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.shieldcommunity.nullcordx.api.events.BotAttackDetectedEvent;
import net.shieldcommunity.nullcordx.api.events.PingAttackDetectedEvent;

public class AttackDetected implements Listener {
    @EventHandler
    public void onBotAttackDetected(BotAttackDetectedEvent event){
        TextChannel textChannel = NullcordDiscordBungeeManager.getChannel();
        textChannel.sendMessageEmbeds(Utils.getDefaultEmbed(Config.onBotAttackTittle(), Config.onBotAttackDescription(), Config.onBotAttackFooter()).build()).queue();
        NullcordDiscordBungeeManager.getPluginLogger().info("Bot attack message sent to Discord");
    }
    @EventHandler
    public void onPingAttackDetected(PingAttackDetectedEvent event){
        TextChannel textChannel = NullcordDiscordBungeeManager.getChannel();
        textChannel.sendMessageEmbeds(Utils.getDefaultEmbed(Config.onPingAttackTittle(), Config.onPingAttackDescription(), Config.onPingAttackFooter()).build()).queue();
        NullcordDiscordBungeeManager.getPluginLogger().info("Ping attack message sent to Discord");
    }
}
