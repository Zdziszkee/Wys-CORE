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
@CommandAlias("heal")
@CommandPermission(CommandPermissions.COMMAND_HEAL)
public class HealCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            if (!(commandSender instanceof Player)) return;
            Player player = (Player) commandSender;
            player.setHealth(player.getMaxHealth());
            commandConfiguration.getSelfHealCommandMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s));
        }
        if (args.length == 1) {
            if (!commandSender.hasPermission(CommandPermissions.COMMAND_HEAL_SOMEONE))return;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s));
                return;
            }
            target.setHealth(target.getMaxHealth());
            commandConfiguration.getSelfHealCommandMessage().forEach(s -> MessageUtil.sendMessage(target,s));
            commandConfiguration.getSomeoneHealCommandMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));
        }
    }
}
