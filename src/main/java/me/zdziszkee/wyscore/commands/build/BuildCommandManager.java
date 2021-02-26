package me.zdziszkee.wyscore.commands.build;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BuildCommandManager {
    private final List<Player> playersWithBlockedBuildings = new ArrayList<>();

    public boolean canPlayerBuild(Player player) {
        return !playersWithBlockedBuildings.contains(player);
    }

    public void addToPlayersWithBlockedBuilding(Player player) {
        this.playersWithBlockedBuildings.add(player);

    }

    public void removeFromPlayersWithBlockedBuilding(Player player) {
        this.playersWithBlockedBuildings.remove(player);
    }

}
