package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("speed")
@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_SPEED)
public class SpeedCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;
    
    @Default
    public void onDefault(Player player, String[] args) {
        if (!StringUtils.isNumeric(args[0])) {
            commandConfiguration.getYouMustProvideANumberMessage().forEach(s -> sendMessage(player,s));
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
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(player,s));
                return;
            }
            int value = Integer.parseInt(args[0]);
            if (value > 10 || value < 0) return;
            target.setFlySpeed(value);
        }

    }

}
