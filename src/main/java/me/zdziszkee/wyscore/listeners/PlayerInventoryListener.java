package me.zdziszkee.wyscore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

public class PlayerInventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Inventory clickedInventory = event.getClickedInventory();
        if(!(clickedInventory instanceof PlayerInventory))return;
        Player whoClicked = (Player) event.getWhoClicked();
        PlayerInventory playerInventory = (PlayerInventory) clickedInventory;
        if(!(whoClicked.getInventory().equals(playerInventory)))return;
        event.setCancelled(true);


    }
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event){
        Inventory clickedInventory = event.getInventory();
        if(!(clickedInventory instanceof PlayerInventory))return;
        Player whoClicked = (Player) event.getWhoClicked();
        PlayerInventory playerInventory = (PlayerInventory) clickedInventory;
        if(!(whoClicked.getInventory().equals(playerInventory)))return;
        event.setCancelled(true);
    }

}
