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

@CommandAlias("ping")
@RequiredArgsConstructor
public class PingCommand extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player) {
        int ping = ((CraftPlayer) (player)).getHandle().ping;
        commandConfiguration.getPingCommandMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace(Placeholders.AMOUNT, String.valueOf(ping)))));
    }

    @Default
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length != 1) return;
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) return;
        int ping = ((CraftPlayer) (player)).getHandle().ping;
        commandConfiguration.getPingCommandMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace(Placeholders.AMOUNT, String.valueOf(ping)))));

    }
}
