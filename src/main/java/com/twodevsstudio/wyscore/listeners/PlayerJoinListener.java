package com.twodevsstudio.wyscore.listeners;

import com.twodevsstudio.wyscore.commands.maintenance.MaintenanceManager;
import com.twodevsstudio.wyscore.commands.vanish.VanishedPlayersManager;
import com.twodevsstudio.wyscore.database.service.CurrencyService;
import com.twodevsstudio.wyscore.database.service.PlayerService;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.configuration.GeneralConfiguration;
import com.twodevsstudio.wyscore.time.PlayerJoinTimeManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.twodevsstudio.wyscore.utils.KickUtil.kickPlayer;


@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {
    private final VanishedPlayersManager vanishedPlayersManager;
    private final GeneralConfiguration generalConfiguration;
    private final PlayerJoinTimeManager playerJoinTimeManager;
    private final MaintenanceManager maintenanceManager;
    private final PlayerService playerService;
    private final CurrencyService currencyService;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        playerService.findByUUID(player.getUniqueId());
        currencyService.findByUUID(player.getUniqueId());
        if (maintenanceManager.isMaintenanceEnabled() && !maintenanceManager.isPlayerAdded(player.getUniqueId())) {
            
            kickPlayer(player, maintenanceManager, generalConfiguration);
        }
        vanishedPlayersManager.addPlayerToHide(player);
        playerJoinTimeManager.addPlayer(player);
        
    }
    
   
}
