package es.angelillo15.nullcord.discord;

import javax.security.auth.login.LoginException;

public class NullcordDiscord extends NullcordDiscordBungeeManager {
    @Override
    public void onEnable() {
        setupLogger();
        registerConfig();
        try {
            setupDiscordBot();
            getLogger().info("Connected to Discord");
        } catch (LoginException e) {
            getLogger().severe("Error while trying to login to Discord. Please check your token.");
            throw new RuntimeException(e);
        }
        registerEvent();
    }
}
