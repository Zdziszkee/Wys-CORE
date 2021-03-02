package me.zdziszkee.wyscore.listeners;

import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.database.service.PlayerService;
import me.zdziszkee.wyscore.time.PlayerJoinTimeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {
    private final PlayerJoinTimeManager playerJoinTimeManager;
    private final PlayerService playerService;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        long timeOnline = playerJoinTimeManager.getTimeOnline(player);
        PlayerService.PlayerData byUUID = playerService.findByUUID(player.getUniqueId());
        byUUID.setOnlineTimeInMillis(byUUID.getOnlineTimeInMillis() + timeOnline);
        playerService.update(player.getUniqueId(), byUUID);
        playerJoinTimeManager.removePlayer(player);
    }
}
