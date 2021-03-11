package com.twodevsstudio.wyscore.utils;

import com.twodevsstudio.wyscore.WysCore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class ConnectionUtil {
    public static void sendPlayerToServer(Player player, String server) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (Exception e) {
            player.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', "&8[&6Bungee&8] &fThere was an problem connecting to " + server + "!"));
            return;
        }
        
        player.sendPluginMessage(WysCore.getInstance(), "BungeeCord", b.toByteArray());
    }
    
}
