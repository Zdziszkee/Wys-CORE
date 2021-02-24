package me.zdziszkee.wyscore.commands.protect;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ProtectedPlayersManager {
    private final List<Player> playersBeingProtected = new ArrayList<>();
    public void addPlayerToProtectedPlayers(Player player){
        playersBeingProtected.add(player);
    }
    public void removePlayerFromProtectedPlayers(Player player){
        playersBeingProtected.remove(player);
    }
    public boolean isPlayerInProtectedPlayers(Player player){
        return playersBeingProtected.contains(player);
    }
}
