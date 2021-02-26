package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Arrays;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_BROADCAST)
@CommandAlias("broadcast|bc")
public class BroadcastCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(args).forEach(s -> stringBuilder.append(s).append(" "));
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', stringBuilder.toString()));
    }
}
