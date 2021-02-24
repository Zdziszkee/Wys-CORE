package me.zdziszkee.wyscore.commands.build;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

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
            commandConfiguration.getBuildCommandEnableMessage().forEach(s -> ChatColor.translateAlternateColorCodes('&', s));
        } else {
            buildCommandManager.addToPlayersWithBlockedBuilding(player);
            commandConfiguration.getBuildCommandDisableMessage().forEach(s -> ChatColor.translateAlternateColorCodes('&',s));
        }
    }
}
