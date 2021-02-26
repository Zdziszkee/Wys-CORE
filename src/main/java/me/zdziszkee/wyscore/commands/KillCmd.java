package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("kill")
public class KillCmd extends BaseCommand {

    @Default
    public void onDefault(Player player) {
        player.setHealth(0);
    }

    @Default
    @CommandPermission(CommandPermissions.COMMAND_KILL)
    public void onDefault(String[] args) {
        if (args.length != 1) return;
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) return;
        player.setHealth(0);
    }

}
