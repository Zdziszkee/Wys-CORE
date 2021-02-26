package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("speed")
@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_SPEED)
public class SpeedCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player, String[] args) {
        if (!StringUtils.isNumeric(args[0])) {
            commandConfiguration.getYouMustProvideANumberMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
            return;
        }
        if (args.length == 1) {
            int value = Integer.parseInt(args[0]);
            if (value > 10 || value < 0) return;
            player.setFlySpeed(value);
        }

        if (args.length != 2) {
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
                return;
            }
            int value = Integer.parseInt(args[0]);
            if (value > 10 || value < 0) return;
            target.setFlySpeed(value);
        }

    }

}
