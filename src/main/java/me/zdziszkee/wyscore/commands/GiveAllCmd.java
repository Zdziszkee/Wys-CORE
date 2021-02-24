package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.permissions.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
@CommandPermission(CommandPermissions.COMMAND_GIVE)
@CommandAlias("giveall")
public class GiveAllCmd extends BaseCommand {
    @Default
    public void onDefault(String[] args){
        if(args.length!=1)return;
        Material material = Material.getMaterial(args[0]);
        if(material==null)return;
        ItemStack itemStack = new ItemStack(material);
        Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().addItem(itemStack));
    }
}
