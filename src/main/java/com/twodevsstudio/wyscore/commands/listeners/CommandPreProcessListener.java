package com.twodevsstudio.wyscore.commands.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class CommandPreProcessListener implements Listener {
    private static final String[] BANNED_COMMANDS = new String[]{
            "bukkit:",
            "spigot:",
            "minecraft:",
            "worldedit",
            "icanhasbukkit",
            "me",
            "say",
            "pl",
            "plugins",
            "ver",
            "version"
    };

    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();
        if (player.isOp()) return;

        for (String string : BANNED_COMMANDS) {
            if (command.startsWith(string)) {
                event.setCancelled(true);
                return;
            }
        }

    }
}
