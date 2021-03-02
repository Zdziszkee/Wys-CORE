package com.twodevsstudio.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.permissions.CommandPermissions;
import com.twodevsstudio.wyscore.utils.MessageUtil;
import com.twodevsstudio.wyscore.utils.Placeholders;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
@CommandAlias("give")
@CommandPermission(CommandPermissions.COMMAND_GIVE)
public class GiveCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;
    @Default
    public void onDefault(CommandSender commandSender,String[] args) {
        if (args.length != 2) return;
        Player player = Bukkit.getPlayer(args[0]);
        Material material = Material.getMaterial(args[1]);
        if (player == null) {
            commandConfiguration.getPlayerNotFoundMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s));
            return;
        }
        if (material == null) {
            commandConfiguration.getInvalidMaterialMessage().forEach(s -> MessageUtil.sendMessage(commandSender,s.replace(Placeholders.MATERIAL,args[1])));
            return;
        }
        player.getInventory().addItem(new ItemStack(material));
    }
}
