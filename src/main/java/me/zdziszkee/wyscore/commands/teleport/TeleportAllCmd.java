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
@CommandPermission(CommandPermissions.COMMAND_TELEPORT_ALL)
@CommandAlias("tpall")
public class TeleportAllCmd extends BaseCommand {
private final TeleportDisabledPlayersManager teleportDisabledPlayersManager;
    @Default
    public void onDefault(Player player){
        Bukkit.getOnlinePlayers().stream().filter(teleportDisabledPlayersManager::isPlayerInPlayersWithBlockedTeleporting).forEach(player1 -> player1.teleport(player));
    }
}
