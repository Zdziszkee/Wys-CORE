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

@CommandPermission(CommandPermissions.COMMAND_SUMMON)
@CommandAlias("summon|s")
@RequiredArgsConstructor
public class SummonCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player, String[] args) {
        if (args.length != 1) return;
        Player target = Bukkit.getPlayer(args[0]);
        if (player == null) return;
        if (!player.hasPermission(new Permission(CommandPermissions.BYPASS_TP_PERMISSION))) {
            if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(target)) {
                commandConfiguration.getThisPlayerHasDisabledTeleportingMessage().forEach(s -> sendMessage(player, s));
                return;
            }
            commandConfiguration.getSummonCommandMessage().forEach(s -> sendMessage(player, s.replace(Placeholders.PLAYER, target.getName())));
            target.teleport(player);
            return;
        }
        commandConfiguration.getSummonCommandMessage().forEach(s -> sendMessage(player, s.replace(Placeholders.PLAYER, target.getName())));
        target.teleport(player);
    }
}
