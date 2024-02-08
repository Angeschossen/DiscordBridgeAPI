package me.angeschossen.discordbridge.api.handler;

import me.angeschossen.discordbridge.api.DiscordBridgeAPI;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class is not intended for direct usage and might change at any time.
 */
public class APIHandler {

    private static APIHandler instance;
    private final DiscordBridgeAPI api;

    @NotNull
    public DiscordBridgeAPI getAPI() {
        return api;
    }

    private APIHandler(@NotNull DiscordBridgeAPI api) {
        this.api = api;
    }

    public static APIHandler getInstance() {
        return instance;
    }

    public static void init(@NotNull DiscordBridgeAPI api) {
        Objects.requireNonNull(api);
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }

        instance = new APIHandler(api);
    }
}
