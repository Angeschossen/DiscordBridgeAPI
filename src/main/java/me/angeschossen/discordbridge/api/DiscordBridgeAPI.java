package me.angeschossen.discordbridge.api;

import me.angeschossen.discordbridge.api.handler.APIHandler;
import me.angeschossen.discordbridge.api.linking.LinkManager;
import org.jetbrains.annotations.NotNull;

public interface DiscordBridgeAPI {

    /**
     * Get implementation of this API.
     * Should only be called after DiscordBridge finished loading.
     * It doesn't need to be fully enabled though.
     *
     * @return implementation of this API
     */
    @NotNull
    static DiscordBridgeAPI getInstance() {
        try {
            return APIHandler.getInstance().getAPI();
        } catch (NullPointerException ex) {
            throw new IllegalStateException("DiscordBridge hasn't loaded yet. Could can only use the API after DiscordBridge finished loading.");
        }
    }

    @NotNull LinkManager getLinkManager();

    void setLinkManager(@NotNull LinkManager linkManager);
}
