package me.zdziszkee.wyscore.commands.teleport;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("tptoggle|tpt")
@RequiredArgsConstructor
public class TeleportToggleCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;

    @Default
    @CommandPermission(CommandPermissions.COMMAND_SELF_TP_TOGGLE)
    public void onDefault(Player player) {

        if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(player)) {
            teleportDisabledPlayersManager.removePlayerFromPlayersWithBlockedTeleporting(player);
        } else {
            teleportDisabledPlayersManager.addPlayerToPlayersWithBlockedTeleporting(player);
        }
    }
    @Default
    @CommandPermission(CommandPermissions.COMMAND_TP_TOGGLE)
    public void onDefault(String[] args) {
        if(args.length!=1)return;
        Player player = Bukkit.getPlayer(args[0]);
        if(player==null)return;
        if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(player)) {
            teleportDisabledPlayersManager.removePlayerFromPlayersWithBlockedTeleporting(player);
        } else {
            teleportDisabledPlayersManager.addPlayerToPlayersWithBlockedTeleporting(player);
        }
    }

}
