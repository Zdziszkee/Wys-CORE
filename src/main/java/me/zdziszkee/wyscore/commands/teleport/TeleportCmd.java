package me.zdziszkee.wyscore.commands.teleport;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("tp")
@CommandPermission(CommandPermissions.COMMAND_TELEPORT)
public class TeleportCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;
    @Default
    public void onDefault(String[] args){
        if(args.length!=2)return;
        Player from = Bukkit.getPlayer(args[0]);
        Player to = Bukkit.getPlayer(args[1]);
        if(teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(from))return;
        if(teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(to))return;
        if(from==null||to==null)return;
        from.teleport(to);
    }
}
