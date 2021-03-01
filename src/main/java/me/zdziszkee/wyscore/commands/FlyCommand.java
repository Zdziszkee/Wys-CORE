package me.zdziszkee.wyscore.commands;

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
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.zdziszkee.wyscore.utils.MessageUtil.sendMessage;

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
                commandConfiguration.getSelfFlyDisableCommandMessage().forEach(s -> sendMessage(commandSender, s));

            } else {
                commandConfiguration.getSelfFlyEnableCommandMessage().forEach(s -> sendMessage(commandSender, s));

            }
            return;
        }
        if (args.length == 1) {
            if (!commandSender.hasPermission(CommandPermissions.COMMAND_GIVE_FLY)) return;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(commandSender, s));
                return;
            }
            boolean isFlyEnabled = target.getAllowFlight();
            target.setAllowFlight(!isFlyEnabled);
            if (isFlyEnabled) {
                commandConfiguration.getSelfFlyDisableCommandMessage().forEach(s -> sendMessage(target, s));
                commandConfiguration.getSomeoneFlyDisableCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));
            } else {
                commandConfiguration.getSelfFlyEnableCommandMessage().forEach(s -> sendMessage(target, s));
                commandConfiguration.getSomeoneFlyEnableCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));

            }
        }
    }
}
