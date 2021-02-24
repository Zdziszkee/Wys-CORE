package me.zdziszkee.wyscore.commands.build;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@RequiredArgsConstructor
public class BuildCommandListener implements Listener {
    private final BuildCommandManager buildCommandManager;

    @EventHandler
    public void onBuild(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!buildCommandManager.canPlayerBuild(player)) event.setCancelled(true);
    }
}
