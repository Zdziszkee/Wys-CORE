package com.twodevsstudio.wyscore.listeners;

import com.twodevsstudio.wyscore.commands.vanish.VanishedPlayersManager;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.configuration.GeneralConfiguration;
import com.twodevsstudio.wyscore.time.PlayerJoinTimeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {
    private final VanishedPlayersManager vanishedPlayersManager;
    private final GeneralConfiguration generalConfiguration;
    private final PlayerJoinTimeManager playerJoinTimeManager;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        vanishedPlayersManager.addPlayerToHide(player);
        playerJoinTimeManager.addPlayer(player);
    }
}
