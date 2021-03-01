package me.zdziszkee.wyscore.listeners;

import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.commands.vanish.VanishedPlayersManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {
    private final VanishedPlayersManager vanishedPlayersManager;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        vanishedPlayersManager.addPlayerToHide(player);
    }
}
