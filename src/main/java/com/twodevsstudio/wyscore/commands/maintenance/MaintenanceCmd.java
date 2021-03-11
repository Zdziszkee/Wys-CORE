package com.twodevsstudio.wyscore.commands.maintenance;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.configuration.GeneralConfiguration;
import com.twodevsstudio.wyscore.utils.KickUtil;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias( "maintenance" )
public class MaintenanceCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;
    private final MaintenanceManager maintenanceManager;
    private final GeneralConfiguration generalConfiguration;
    
    @Subcommand( "on" )
    public void enable() {
        
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            KickUtil.kickPlayer(onlinePlayer, maintenanceManager, generalConfiguration);
        }
        maintenanceManager.setMaintenanceEnabled(true);
    }
    
    @Subcommand( "off" )
    public void disable() {
        
        maintenanceManager.setMaintenanceEnabled(false);
    }
    
    @Subcommand( "add" )
    public void add(String[] args) {
        
        if (args.length != 1) {
            return;
        }
        
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
        if (offlinePlayer == null) {
            return;
        }
        maintenanceManager.addAllowedPlayer(offlinePlayer.getUniqueId());
    }
    
    
}
