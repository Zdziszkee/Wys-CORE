package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import com.twodevsstudio.wyscore.utils.MessageUtil;
import com.twodevsstudio.wyscore.utils.Placeholders;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("fly")
public class FlyCommand extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    @CommandPermission(CommandPermissions.COMMAND_FLY)
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            if (!(commandSender instanceof Player)) return;
            Player player = (Player) commandSender;
            boolean isFlyEnabled = player.getAllowFlight();
            player.setAllowFlight(!isFlyEnabled);
            if (isFlyEnabled) {
                commandConfiguration.getSelfFlyDisableCommandMessage().forEach(s -> MessageUtil.sendMessage(commandSender, s));

            } else {
                commandConfiguration.getSelfFlyEnableCommandMessage().forEach(s -> MessageUtil.sendMessage(commandSender, s));

            }
            return;
        }
        if (args.length == 1) {
            if (!commandSender.hasPermission(CommandPermissions.COMMAND_GIVE_FLY)) return;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> MessageUtil.sendMessage(commandSender, s));
                return;
            }
            boolean isFlyEnabled = target.getAllowFlight();
            target.setAllowFlight(!isFlyEnabled);
            if (isFlyEnabled) {
                commandConfiguration.getSelfFlyDisableCommandMessage().forEach(s -> MessageUtil.sendMessage(target, s));
                commandConfiguration.getSomeoneFlyDisableCommandMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));
            } else {
                commandConfiguration.getSelfFlyEnableCommandMessage().forEach(s -> MessageUtil.sendMessage(target, s));
                commandConfiguration.getSomeoneFlyEnableCommandMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));

            }
        }
    }
}
