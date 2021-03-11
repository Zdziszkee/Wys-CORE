package com.twodevsstudio.wyscore.commands.maintenance;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MaintenanceManager {
    private boolean isMaintenanceEnabled = false;
    private final List<UUID> allowedPlayers = new ArrayList<>();
    
    public void addAllowedPlayer(UUID player) {
        
        allowedPlayers.add(player);
    }
    
    public void deleteAllowedPlayer(UUID player) {
        
        allowedPlayers.remove(player);
    }
    
    public boolean isPlayerAdded(UUID player) {
        
        return allowedPlayers.contains(player);
    }
    
    public boolean isMaintenanceEnabled() {
        
        return isMaintenanceEnabled;
    }
    
    public void setMaintenanceEnabled(boolean maintenanceEnabled) {
        
        isMaintenanceEnabled = maintenanceEnabled;
    }
}
