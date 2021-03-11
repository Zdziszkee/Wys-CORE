package com.twodevsstudio.wyscore.listeners;

import com.twodevsstudio.wyscore.database.service.CurrencyService;
import com.twodevsstudio.wyscore.database.service.PlayerService;
import com.twodevsstudio.wyscore.time.PlayerJoinTimeManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {
    private final PlayerJoinTimeManager playerJoinTimeManager;
    private final PlayerService playerService;
    private final CurrencyService currencyService;
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        long timeOnline = playerJoinTimeManager.getTimeOnline(player);
        playerJoinTimeManager.removePlayer(player);
        PlayerService.PlayerData byUUID = playerService.findByUUID(player.getUniqueId());
        byUUID.setOnlineTimeInMillis(byUUID.getOnlineTimeInMillis() + timeOnline);
        playerService.update(player.getUniqueId());
        playerService.removeFromCache(player.getUniqueId());
        currencyService.update(player.getUniqueId());
        currencyService.removeFromCache(player.getUniqueId());
    }
}
