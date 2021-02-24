package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandPermission(CommandPermissions.COMMAND_INVSEE)
@RequiredArgsConstructor
@CommandAlias("invsee|inventorysee")
public class InvseeCmd extends BaseCommand {
    @Default
    public void onDefault(Player player,String[] args){
        if(args.length!=1)return;
        Player target = Bukkit.getPlayer(args[0]);
        if(target==null)return;
        player.openInventory(target.getInventory());
    }
}
