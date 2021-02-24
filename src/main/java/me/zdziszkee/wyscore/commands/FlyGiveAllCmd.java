package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_GIVE_ALL_FLY)
@CommandAlias("flyall")
public class FlyGiveAllCmd extends BaseCommand {
    @Default
    public void onDefault(){
        Bukkit.getOnlinePlayers().forEach(player -> player.setAllowFlight(true));
    }
}
