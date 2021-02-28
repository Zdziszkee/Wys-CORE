package me.zdziszkee.wyscore.commands.teleport;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import me.zdziszkee.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static me.zdziszkee.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("tptoggle|tpt")
@RequiredArgsConstructor
public class TeleportToggleCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;
    private final CommandConfiguration commandConfiguration;
    @Default
    @CommandPermission(CommandPermissions.COMMAND_SELF_TP_TOGGLE)
    public void onDefault(Player player) {

        if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(player)) {
            teleportDisabledPlayersManager.removePlayerFromPlayersWithBlockedTeleporting(player);
            commandConfiguration.getSelfTeleportingDisabledMessage().forEach(s -> sendMessage(player,s));
        } else {
            teleportDisabledPlayersManager.addPlayerToPlayersWithBlockedTeleporting(player);
            commandConfiguration.getSelfTeleportingEnabledMessage().forEach(s -> sendMessage(player,s));

        }
    }

    @Default
    @CommandPermission(CommandPermissions.COMMAND_TP_TOGGLE)
    public void onDefault(Player player,String[] args) {
        if (args.length != 1) return;
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) return;
        if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(target)) {
            teleportDisabledPlayersManager.removePlayerFromPlayersWithBlockedTeleporting(target);
            commandConfiguration.getTeleportingDisabledMessage().forEach(s -> sendMessage(player,s.replace(Placeholders.PLAYER,target.getName())));

        } else {
            teleportDisabledPlayersManager.addPlayerToPlayersWithBlockedTeleporting(target);
            commandConfiguration.getTeleportingEnabledMessage().forEach(s -> sendMessage(player,s.replace(Placeholders.PLAYER,target.getName())));

        }
    }

}
