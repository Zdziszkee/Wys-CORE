package com.twodevsstudio.wyscore.commands.teleport;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

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
                commandConfiguration.getThisPlayerHasDisabledTeleportingMessage().forEach(s -> sendMessage(player,s));
                return;
            }
        }
        commandConfiguration.getTeleportCommandMessage().forEach(s -> sendMessage(player,s.replace(Placeholders.PLAYER,from.getName()).replace("%target%",to.getName())));
        from.teleport(to);
    }
}
