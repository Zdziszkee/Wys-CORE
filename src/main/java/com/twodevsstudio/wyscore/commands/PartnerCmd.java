package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@CommandAlias("partner")
@RequiredArgsConstructor
public class PartnerCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player) {
        commandConfiguration.getPartnerCommandMessage().forEach(s -> sendMessage(player,s));
    }
}
