package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_CLEAR_INVENTORY)
@CommandAlias("clearinventory|ci")
public class ClearInventoryCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;


    @Default
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            if (!(commandSender instanceof Player)) return;
            Player player = (Player) commandSender;
            player.getInventory().clear();
            commandConfiguration.getSelfClearInventoryCommandMessage().forEach(s -> sendMessage(player,s));
        }
        if (args.length == 1) {
            if (!commandSender.hasPermission(CommandPermissions.COMMAND_CLEAR_SOMEONE_INVENTORY))return;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(commandSender,s));
                return;
            }
            target.getInventory().clear();
            commandConfiguration.getClearInventoryCommandMessage().forEach(s -> sendMessage(commandSender,s));
            commandConfiguration.getSelfClearInventoryCommandMessage().forEach(s -> sendMessage(target,s));

        }
    }
}

