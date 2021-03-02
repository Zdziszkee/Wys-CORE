package com.twodevsstudio.wyscore.commands.protect;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@RequiredArgsConstructor
@CommandAlias("protect")
public class ProtectCmd extends BaseCommand {
    private final ProtectedPlayersManager protectedPlayersManager;
    private final CommandConfiguration commandConfiguration;

    @Default
    @CommandPermission(CommandPermissions.COMMAND_PROTECT)
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            if (!(commandSender instanceof Player)) return;
            Player player = (Player) commandSender;
            if (protectedPlayersManager.isPlayerInProtectedPlayers(player)) {
                protectedPlayersManager.removePlayerFromProtectedPlayers(player);
                commandConfiguration.getProtectCommandDisableMessage().forEach(s -> sendMessage(player,s));
            } else {
                protectedPlayersManager.addPlayerToProtectedPlayers(player);
                commandConfiguration.getProtectCommandEnableMessage().forEach(s -> sendMessage(player,s));
            }

        }

        if (args.length == 1) {
            if(!commandSender.hasPermission(CommandPermissions.COMMAND_PROTECT_SOMEONE))return;
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s-> sendMessage(commandSender,s));
                return;
            }
            if (protectedPlayersManager.isPlayerInProtectedPlayers(player)) {
                protectedPlayersManager.removePlayerFromProtectedPlayers(player);
                commandConfiguration.getProtectSomeoneCommandDisableMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,player.getName())));
                commandConfiguration.getProtectCommandDisableMessage().forEach(s -> sendMessage(player,s));

            } else {
                protectedPlayersManager.addPlayerToProtectedPlayers(player);
                commandConfiguration.getProtectSomeoneEnableMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,player.getName())));
                commandConfiguration.getProtectCommandEnableMessage().forEach(s -> sendMessage(player,s));

            }
        }
    }
}
