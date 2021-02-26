package me.zdziszkee.wyscore.commands.protect;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@RequiredArgsConstructor
public class ProtectedPlayerDamageListener implements Listener {
    private final ProtectedPlayersManager protectedPlayersManager;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (!(damager instanceof Player)) return;
        Entity victim = event.getEntity();
        if (!(victim instanceof Player)) return;
        Player playerVictim = (Player) victim;
        if (protectedPlayersManager.isPlayerInProtectedPlayers(playerVictim)) event.setCancelled(true);
    }
}
