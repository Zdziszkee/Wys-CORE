package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.zdziszkee.wyscore.utils.MessageUtil.sendMessage;

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
        if (args.length != 1) {
            if (!commandSender.hasPermission(CommandPermissions.COMMAND_CLEAR_SOMEONE_INVENTORY))return;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
                return;
            }
            target.getInventory().clear();
            commandConfiguration.getClearInventoryCommandMessage().forEach(s -> target.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));

        }
    }
}

