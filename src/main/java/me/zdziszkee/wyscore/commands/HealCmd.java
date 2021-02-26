package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("heal")
@CommandPermission(CommandPermissions.COMMAND_HEAL)
public class HealCmd extends BaseCommand {
    @Default
    public void onDefault(String[] args) {
        if (args.length != 1) return;
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) return;
        player.setHealth(player.getMaxHealth());
    }
}
