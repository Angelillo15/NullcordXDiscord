package es.angelillo15.nullcord.discord.listeners;

import es.angelillo15.nullcord.discord.NullcordDiscord;
import es.angelillo15.nullcord.discord.NullcordDiscordBungeeManager;
import es.angelillo15.nullcord.discord.config.Config;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;


public class OnReady extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        NullcordDiscordBungeeManager.channel = event.getJDA().getGuildById(Config.guild()).getTextChannelById(Long.parseLong(Config.getChannelID()));
    }
}
