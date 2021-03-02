package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@CommandPermission(CommandPermissions.COMMAND_INVSEE)
@RequiredArgsConstructor
@CommandAlias("invsee|inventorysee")
public class InvseeCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player, String[] args) {
        if (args.length != 1) return;
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(player,s));
            return;
        }
        player.openInventory(target.getInventory());
    }
}
