package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_CLEAR_CHAT)
@CommandAlias("cc|clearchat")
public class ClearChatCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault() {
        for (int i = 0; i < 100; i++) {
            Bukkit.broadcastMessage("                                                      ");
        }
        commandConfiguration.getClearChatCommandMessage().forEach(s -> Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', s)));

    }
}
