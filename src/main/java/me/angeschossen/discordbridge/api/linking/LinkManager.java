package me.angeschossen.discordbridge.api.linking;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface LinkManager {

    /**
     * Get Discord id of a minecraft player.
     *
     * @param uuid UID of minecraft player
     * @return Discord ID. Null if not linked.
     */
    @NotNull
    CompletableFuture<Long> getDiscordIdFromMinecraftUUID(@NotNull UUID uuid);

    /**
     * Get uid of a minecraft player by his discord id
     *
     * @param discordId Discord id
     * @return Minecraft uid. Null if not linked.
     */
    @NotNull
    CompletableFuture<UUID> getMinecraftUUIDFromDiscordId(long discordId);

    /**
     * Get status of link manager. This is useful if you use asynchronous database access on startup.
     *
     * @return Linkmanager status
     */
    boolean isReady();

    /**
     * Get link usage
     * Example: discord link
     */
    @NotNull
    String getUsage();

    @NotNull Map<String, UUID> getAllLinksForMigration();

    /**
     * @return The plugin that provides this link manager.
     */
    @NotNull Plugin getPlugin();
}
