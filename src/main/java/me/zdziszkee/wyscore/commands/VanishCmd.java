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
@CommandAlias("vanish|v")
@CommandPermission(CommandPermissions.COMMAND_VANISH)
public class VanishCmd extends BaseCommand {
    @Default
    public void onDefault(Player player,String[] args){
        if(args.length==0){
            Bukkit.getOnlinePlayers().forEach(player::hidePlayer);
            return;
        }
        if(args.length==1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target==null)return;
            Bukkit.getOnlinePlayers().forEach(target::hidePlayer);

        }
    }
}
