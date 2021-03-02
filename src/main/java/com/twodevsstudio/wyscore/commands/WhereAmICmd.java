package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import lombok.RequiredArgsConstructor;
import com.twodevsstudio.wyscore.utils.Placeholders;
import org.bukkit.entity.Player;

import static com.twodevsstudio.wyscore.utils.MessageUtil.sendMessage;

@RequiredArgsConstructor
@CommandAlias("whereami")
public class WhereAmICmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player) {
        commandConfiguration.getWhereAmICommandMessage().forEach(s -> sendMessage(player,s.replace(Placeholders.SERVER, player.getServer().getServerName())));
    }
}
