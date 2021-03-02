package com.twodevsstudio.wyscore.commands.vanish;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@RequiredArgsConstructor
@CommandAlias("vanish|v")
@CommandPermission(CommandPermissions.COMMAND_VANISH)
public class VanishCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;
    private final VanishedPlayersManager vanishedPlayersManager;
    @Default
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            if(!(commandSender instanceof Player))return;
            Player player = (Player) commandSender;
            boolean isPlayerVanished = vanishedPlayersManager.isPlayerVanished(player.getUniqueId());
            if(isPlayerVanished){
                commandConfiguration.getSelfVanishDisableCommandMessage().forEach(s -> sendMessage(player,s));
            }else {
                commandConfiguration.getSelfVanishEnableCommandMessage().forEach(s -> sendMessage(player,s));

            }
            vanishedPlayersManager.toggleVanish(player.getUniqueId());
            return;
        }
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(commandSender, s));
                return;
            }
            boolean isPlayerVanished = vanishedPlayersManager.isPlayerVanished(target.getUniqueId());
            if(isPlayerVanished){
                commandConfiguration.getSelfVanishDisableCommandMessage().forEach(s -> sendMessage(target,s));
                commandConfiguration.getSomeoneVanishDisableCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));
            }else {
                commandConfiguration.getSelfVanishEnableCommandMessage().forEach(s -> sendMessage(target,s));
                commandConfiguration.getSomeoneVanishDisableCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.PLAYER,target.getName())));

            }
            vanishedPlayersManager.toggleVanish(target.getUniqueId());
        }
    }
}
