package me.zdziszkee.wyscore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("speed")
@RequiredArgsConstructor
public class SpeedCmd extends BaseCommand {

    @Default
    public void onDefault(Player player,String[] args){
        if(args.length!=1)return;
        if (!StringUtils.isNumeric(args[0]))return;
        int value = Integer.parseInt(args[0]);
        if(value>10||value<0)return;
        player.setFlySpeed(value);
    }
    @Default
    public void onDefault(String[] args){
        if(args.length!=2)return;
        Player player = Bukkit.getPlayer(args[1]);
        if(player==null)return;
        if (!StringUtils.isNumeric(args[0]))return;
        int value = Integer.parseInt(args[0]);
        if(value>10||value<0)return;
        player.setFlySpeed(value);
    }
}
