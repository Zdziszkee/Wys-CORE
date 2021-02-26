package me.zdziszkee.wyscore.commands.protect;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("protect")
public class ProtectCmd extends BaseCommand {
    private final ProtectedPlayersManager protectedPlayersManager;
    private final CommandConfiguration commandConfiguration;

    @Default
    @CommandPermission(CommandPermissions.COMMAND_PROTECT)
    public void onDefault(Player player) {
        if (protectedPlayersManager.isPlayerInProtectedPlayers(player)) {
            protectedPlayersManager.removePlayerFromProtectedPlayers(player);
            commandConfiguration.getProtectCommandDisableMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        } else {
            protectedPlayersManager.addPlayerToProtectedPlayers(player);
            commandConfiguration.getProtectCommandEnableMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        }
    }

    @Default
    @CommandPermission(CommandPermissions.COMMAND_PROTECT_SOMEONE)
    public void onDefault(String[] args) {
        if (args.length != 1) return;
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) return;
        if (protectedPlayersManager.isPlayerInProtectedPlayers(player)) {
            protectedPlayersManager.removePlayerFromProtectedPlayers(player);
            commandConfiguration.getProtectCommandDisableMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        } else {
            protectedPlayersManager.addPlayerToProtectedPlayers(player);
            commandConfiguration.getProtectCommandEnableMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        }
    }
}
