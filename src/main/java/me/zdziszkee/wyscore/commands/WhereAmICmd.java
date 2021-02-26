package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.utils.Placeholders;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("whereami")
public class WhereAmICmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(Player player) {
        commandConfiguration.getWhereAmICommandMessage().forEach(s -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace(Placeholders.SERVER, player.getServer().getName()))));
    }
}
