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

import static me.zdziszkee.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("list|online")
@RequiredArgsConstructor
public class OnlineListCmd extends BaseCommand {
    private CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(CommandSender commandSender) {
        int amount = Bukkit.getOnlinePlayers().size();
        commandConfiguration.getOnlineCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.AMOUNT, String.valueOf(amount))));
    }
}
