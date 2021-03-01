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
            commandConfiguration.getSelfHealCommandMessage().forEach(s -> sendMessage(commandSender,s));
        }
        if (args.length == 1) {
            if (!commandSender.hasPermission(CommandPermissions.COMMAND_HEAL_SOMEONE))return;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(commandSender,s));
                return;
            }
            target.setHealth(target.getMaxHealth());
            commandConfiguration.getSelfHealCommandMessage().forEach(s -> sendMessage(target,s));
            commandConfiguration.getSomeoneHealCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));
        }
    }
}
