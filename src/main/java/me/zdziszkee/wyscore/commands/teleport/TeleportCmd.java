package me.zdziszkee.wyscore.commands.teleport;

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
import org.bukkit.permissions.Permission;

@RequiredArgsConstructor
@CommandAlias("tp")
@CommandPermission(CommandPermissions.COMMAND_TELEPORT)
public class TeleportCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;
    private final CommandConfiguration commandConfiguration;
    @Default
    public void onDefault(Player player,String[] args) {
        if (args.length != 2) return;
        Player from = Bukkit.getPlayer(args[0]);
        Player to = Bukkit.getPlayer(args[1]);
        if (from == null || to == null) return;
        if (!from.hasPermission(new Permission(CommandPermissions.BYPASS_TP_PERMISSION))) {
            if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(from)||teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(to)){
                commandConfiguration.getThisPlayerHasDisabledTeleportingMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
                return;
            }
        }

        from.teleport(to);
    }
}
