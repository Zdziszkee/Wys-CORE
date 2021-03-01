package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import me.zdziszkee.wyscore.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.zdziszkee.wyscore.utils.MessageUtil.sendMessage;

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
            commandConfiguration.getPlayerNotFoundMessage().forEach(s -> sendMessage(commandSender,s));
            return;
        }
        if (material == null) {
            commandConfiguration.getInvalidMaterialMessage().forEach(s -> sendMessage(commandSender,s.replace(Placeholders.MATERIAL,args[1])));
            return;
        }
        player.getInventory().addItem(new ItemStack(material));
    }
}
