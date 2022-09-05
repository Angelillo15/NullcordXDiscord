package es.angelillo15.nullcord.discord.cmd;

import es.angelillo15.nullcord.discord.NullcordDiscordBungeeManager;
import es.angelillo15.nullcord.discord.config.ConfigLoader;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MainCMD extends Command {
    public MainCMD() {
        super("ndiscord");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (!(commandSender instanceof ProxiedPlayer)) {
            NullcordDiscordBungeeManager.getPluginLogger().info("Reloading the plugin...");
            ConfigLoader.getConfig().registerConfig();
            NullcordDiscordBungeeManager.getPluginLogger().info("Plugin reloaded!");
        } else {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if (args.length == 0) {
                player.sendMessage(new TextComponent("§cUsage: /ndiscord reload"));
            } else {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!(player.hasPermission("ndiscord.reload"))) {
                        player.sendMessage(new TextComponent("§cYou don't have permission to do that!"));
                        return;
                    }
                    player.sendMessage(new TextComponent("§aReloading the plugin..."));
                    ConfigLoader.getConfig().registerConfig();
                }
            }
        }
    }
}
