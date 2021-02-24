package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("fly")
public class FlyCommand extends BaseCommand {
    private final CommandConfiguration commandConfiguration;
    @Default
    @CommandPermission(CommandPermissions.COMMAND_FLY)
    public void onDefault(Player player){
        player.setAllowFlight(!player.getAllowFlight());
    }
    @Default
    @CommandPermission(CommandPermissions.COMMAND_GIVE_FLY)
    public void onDefault(CommandSender commandSender,String[] args){
        if(args.length!=1)return;
        Player player = Bukkit.getPlayer(args[0]);
        if(player==null){
            commandConfiguration.getFlyCommandPlayerNotFoundMessage().forEach(s -> commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',s)));
            return;
        }
        player.setAllowFlight(player.getAllowFlight());
    }
}
