package me.zdziszkee.wyscore.commands.teleport;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
@CommandPermission(CommandPermissions.COMMAND_SUMMON)
@CommandAlias("summon|s")
@RequiredArgsConstructor
public class SummonCmd extends BaseCommand {
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;
    @Default
    public void onDefault(Player player,String[] args){
        if(args.length!=1)return;
        Player target = Bukkit.getPlayer(args[0]);
        if(player==null)return;
        if (teleportDisabledPlayersManager.isPlayerInPlayersWithBlockedTeleporting(target))return;
        target.teleport(player);
    }
}
