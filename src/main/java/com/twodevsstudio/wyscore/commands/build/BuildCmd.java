package com.twodevsstudio.wyscore.commands.build;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("build")
@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_BUILD)
public class BuildCmd extends BaseCommand {
    private final BuildCommandManager buildCommandManager;
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player) {
        boolean canPlayerBuild = buildCommandManager.canPlayerBuild(player);
        if (!canPlayerBuild) {
            buildCommandManager.removeFromPlayersWithBlockedBuilding(player);
            commandConfiguration.getBuildCommandEnableMessage().forEach(s -> sendMessage(player,s));
        } else {
            buildCommandManager.addToPlayersWithBlockedBuilding(player);
            commandConfiguration.getBuildCommandDisableMessage().forEach(s -> sendMessage(player,s));
        }
    }
}
