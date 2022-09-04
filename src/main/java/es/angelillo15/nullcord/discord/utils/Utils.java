package es.angelillo15.nullcord.discord.utils;

import es.angelillo15.nullcord.discord.config.Config;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.Color;

public class Utils {
    public static EmbedBuilder getDefaultEmbed(String title, String description, String footer){
        return new EmbedBuilder()
                .setColor(Color.getColor(Config.defaultColor()))
                .setDescription(description)
                .setTitle(title)
                .setFooter(footer);
    }
}
