package me.zdziszkee.wyscore.commands.teleport;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_TELEPORT_ALL)
@CommandAlias("tpall")
public class TeleportAllCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;

    @Default
    public void onDefault(Player player) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!player.hasPermission(new Permission(CommandPermissions.BYPASS_TP_PERMISSION))) {
                if (!teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(onlinePlayer)) {
                    onlinePlayer.teleport(player);
                }
                continue;
            }
            onlinePlayer.teleport(player);
        }
    }
}
