package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("list|online")
@RequiredArgsConstructor
public class OnlineListCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(CommandSender commandSender) {
        int amount = Bukkit.getOnlinePlayers().size();
        commandConfiguration.getOnlineCommandMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.AMOUNT, String.valueOf(amount))));
    }
}
