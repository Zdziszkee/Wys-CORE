package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static me.zdziszkee.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("ping")
@RequiredArgsConstructor
public class PingCommand extends BaseCommand {
    private final CommandConfiguration commandConfiguration;


    @Default
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            if (!(commandSender instanceof Player)) return;
            Player player = (Player) commandSender;
            int ping = ((CraftPlayer) (player)).getHandle().ping;
            commandConfiguration.getPingCommandMessage().forEach(s -> sendMessage(player,s.replace(Placeholders.AMOUNT, String.valueOf(ping))));
        }
        if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(player,s));
                return;
            }
            int ping = ((CraftPlayer) (player)).getHandle().ping;
            commandConfiguration.getPingCommandMessage().forEach(s -> sendMessage(player,s.replace(Placeholders.AMOUNT, String.valueOf(ping))));
        }
    }
}
