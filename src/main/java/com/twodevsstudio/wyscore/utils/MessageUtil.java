package com.twodevsstudio.wyscore.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageUtil {
    public static void sendMessage(CommandSender commandSender,String message){
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }
}
