package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_GIVE_ALL_FLY)
@CommandAlias("flyall")
public class FlyGiveAllCmd extends BaseCommand {
    @Default
    public void onDefault() {
        Bukkit.getOnlinePlayers().forEach(player -> player.setAllowFlight(true));
    }
}
