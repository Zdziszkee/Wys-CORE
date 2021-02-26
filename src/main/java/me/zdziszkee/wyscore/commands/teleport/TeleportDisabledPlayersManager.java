package me.zdziszkee.wyscore.commands.teleport;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TeleportDisabledPlayersManager {
    private final List<Player> playersWithBlockedTeleporting = new ArrayList<>();

    public void addPlayerToPlayersWithBlockedTeleporting(Player player) {
        playersWithBlockedTeleporting.add(player);
    }

    public void removePlayerFromPlayersWithBlockedTeleporting(Player player) {
        playersWithBlockedTeleporting.remove(player);
    }

    public boolean isPlayerInPlayersWithBlockedTeleporting(Player player) {
        return playersWithBlockedTeleporting.contains(player);
    }
}
