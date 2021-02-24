package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
@CommandAlias("give")
@CommandPermission(CommandPermissions.COMMAND_GIVE)
public class GiveCmd extends BaseCommand {
    @Default
    public void onDefault(String[] args) {
        if (args.length != 2) return;
        Player player = Bukkit.getPlayer(args[0]);
        Material material = Material.getMaterial(args[1]);
        if (player == null || material == null) return;
        player.getInventory().addItem(new ItemStack(material));
    }
}
