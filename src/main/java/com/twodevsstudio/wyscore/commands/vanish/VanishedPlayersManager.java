package com.twodevsstudio.wyscore.commands.vanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishedPlayersManager {
    private final List<UUID> vanishedPlayers = new ArrayList<>();

    public boolean isPlayerVanished(UUID uuid){
        return vanishedPlayers.contains(uuid);
    }
    public void addVanishedPlayer(UUID uuid){
        vanishedPlayers.add(uuid);
        Player target = Bukkit.getPlayer(uuid);
        Bukkit.getOnlinePlayers().forEach(player -> player.hidePlayer(target));
    }
    public void removeVanishedPlayer(UUID uuid){
        vanishedPlayers.remove(uuid);
        Player target = Bukkit.getPlayer(uuid);
        Bukkit.getOnlinePlayers().forEach(player -> player.hidePlayer(target));
    }
    public void addPlayerToHide(Player playerToHide){
        vanishedPlayers.forEach(uuid -> {
            Player target = Bukkit.getPlayer(uuid);
            if (target == null) {
                vanishedPlayers.remove(uuid);
            } else {
                target.hidePlayer(playerToHide);
            }
        });
    }
    public void toggleVanish(UUID uuid){
        if (isPlayerVanished(uuid)) {
            removeVanishedPlayer(uuid);
        }else {
            addVanishedPlayer(uuid);
        }
    }
}
