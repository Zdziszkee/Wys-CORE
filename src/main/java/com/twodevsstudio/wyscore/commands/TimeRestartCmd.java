package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.WysCore;
import com.twodevsstudio.wyscore.utils.Placeholders;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

@CommandAlias( "trestart|timerestart" )
@CommandPermission( CommandPermissions.COMMAND_TIME_RESTART )
@RequiredArgsConstructor
public class TimeRestartCmd extends BaseCommand {
    private final WysCore wysCORE;
    private final CommandConfiguration commandConfiguration;
    
    @Default
    public void onDefault(String[] args) {
    
        if (args.length != 1) {
            return;
        }
        if (!StringUtils.isNumeric(args[0])) {
            return;
        }
        int time = Integer.parseInt(args[0]);
        commandConfiguration.getServerRestartCommandMessage()
                .forEach(s -> Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                        s.replace(Placeholders.AMOUNT, String.valueOf(time))
                )));
        Bukkit.getScheduler().runTaskLater(wysCORE, () -> {
            
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
        }, time * 20L);
    }
}
