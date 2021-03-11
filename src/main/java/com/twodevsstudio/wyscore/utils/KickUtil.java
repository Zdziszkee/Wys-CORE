package com.twodevsstudio.wyscore.utils;

import com.twodevsstudio.wyscore.commands.maintenance.MaintenanceManager;
import com.twodevsstudio.wyscore.configuration.GeneralConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class KickUtil {
    public static void kickPlayer(Player player, MaintenanceManager maintenanceManager, GeneralConfiguration generalConfiguration) {
        if (!maintenanceManager.isPlayerAdded(player.getUniqueId())) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String reasonLine : generalConfiguration.getMaintenanceKickMessage()) {
                stringBuilder.append(reasonLine).append("\n");
            }
            String reason = ChatColor.translateAlternateColorCodes('&', stringBuilder.toString());
            player.kickPlayer(reason);
        }
    }
}
