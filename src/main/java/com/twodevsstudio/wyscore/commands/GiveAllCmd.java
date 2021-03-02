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
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_GIVE)
@CommandAlias("giveall")
public class GiveAllCmd extends BaseCommand {
    private final CommandConfiguration commandConfiguration;

    @Default
    public void onDefault(CommandSender commandSender, String[] args) {
        if (args.length != 1) return;
        Material material = Material.getMaterial(args[0]);
        if (material == null) {
            commandConfiguration.getInvalidMaterialMessage().forEach(s ->  MessageUtil.sendMessage(commandSender,s.replace(Placeholders.MATERIAL, args[0])));

            return;
        }
        ItemStack itemStack = new ItemStack(material);
        Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().addItem(itemStack));
    }
}
