package me.zdziszkee.wyscore.auth;

import me.zdziszkee.wyscore.configuration.PatternFinderAuthGUIConfiguration;
import me.zdziszkee.wyscore.gui.GUI;
import me.zdziszkee.wyscore.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang.math.RandomUtils.nextInt;

public class PatternFinderAuthGUI implements GUI {
    private final Inventory inventory;
    private final Player player;
    private final PatternFinderAuthGUIConfiguration patternFinderGUIConfiguration;
    private final Set<Integer> generatedGreenGlassSlots = new HashSet<>();
    private final int[] inputGreenSlots = new int[]{
            -1,
            -1,
            -1,
            -1
    };

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        int slot = inventoryClickEvent.getSlot();

        if (slot >= 45 && slot <= 54) {
            for (int i = 0; i < inputGreenSlots.length; i++) {
                if (inputGreenSlots[i] == -1) {
                    inputGreenSlots[i] = slot;
                    break;
                }
            }
        }
        if(slot==23){
            if (isPatternCorrect()) {
                Bukkit.broadcastMessage("pattern is correct");
            }else {
                resetAuth();
            }
        }
        if (slot == 21) {
           resetAuth();
        }
        updateInventory();
    }
    private void resetAuth(){
        Arrays.fill(inputGreenSlots, -1);
        generatedGreenGlassSlots.clear();
        for (int i = 0; i < 4; i++) {
            generatedGreenGlassSlots.add(nextInt(9));
        }
    }

    public PatternFinderAuthGUI(Player player, PatternFinderAuthGUIConfiguration patternFinderGUIConfiguration) {
        this.player = player;
        this.patternFinderGUIConfiguration = patternFinderGUIConfiguration;
        this.inventory = Bukkit.createInventory(this, 54, ChatColor.translateAlternateColorCodes('&', patternFinderGUIConfiguration.getInventoryName()));
    }

    private ItemStack[] getInventoryContents() {
        Inventory temp = Bukkit.createInventory(null, 54);

        temp.setItem(21, patternFinderGUIConfiguration.getCancelHead().getItemStack());
        temp.setItem(22, patternFinderGUIConfiguration.getInformationHead().getItemStack());
        temp.setItem(23, patternFinderGUIConfiguration.getProceedHead().getItemStack());

        for (int i = 0; i < 9; i++) {
            temp.setItem(i, getPatternGlassPane(i));
        }

        for (int i = 45; i < 54; i++) {
            temp.setItem(i, getInputGlassPane(i));
        }
        return temp.getContents();
    }

    private void updateInventory() {
        this.inventory.setContents(getInventoryContents());
    }

    public void openInventory() {
        resetAuth();
        updateInventory();
        player.openInventory(inventory);
    }
    private boolean isPatternCorrect(){
        for (int inputGreenSlot : inputGreenSlots) {
            if(inputGreenSlot==-1)continue;
            if(!isInputValid(inputGreenSlot-(9*5)))return false;
        }
        return true;
    }

    private boolean isInputValid(int slot){
         for (int generatedGreenGlassSlot : generatedGreenGlassSlots) {
                if(generatedGreenGlassSlot==(slot))return true;
        }
         return false;
    }

    private ItemStack getPatternGlassPane(int slot) {
        ItemStack redGlassPane = GUIUtils.getGlassPane(14);
        ItemStack greenGlassPane = GUIUtils.getGlassPane(5);
        for (int generatedRedGlassSlot : generatedGreenGlassSlots) {
            if (generatedRedGlassSlot == slot) return greenGlassPane;
        }
        return redGlassPane;
    }

    private ItemStack getInputGlassPane(int slot) {
        ItemStack redGlassPane = GUIUtils.getGlassPane(14);
        ItemStack greenGlassPane = GUIUtils.getGlassPane(5);
        for (int inputRedSlot : inputGreenSlots) {
            if (inputRedSlot == slot) return greenGlassPane;
        }
        return redGlassPane;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

}
