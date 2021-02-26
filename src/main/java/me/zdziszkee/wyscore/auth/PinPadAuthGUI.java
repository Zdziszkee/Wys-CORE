package me.zdziszkee.wyscore.auth;

import me.zdziszkee.wyscore.configuration.PinPadAuthGUIConfiguration;
import me.zdziszkee.wyscore.gui.GUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class PinPadAuthGUI implements GUI {
    private final PinPadAuthGUIConfiguration pinPadAuthGUIConfiguration;
    private int generatedPin = ThreadLocalRandom.current().nextInt(0, 99999);
    private final Inventory inventory;
    private final byte[] inputs = new byte[]{-1, -1, -1, -1, -1};
    private final Player player;

    public PinPadAuthGUI(PinPadAuthGUIConfiguration pinPadAuthGUIConfiguration, Player player) {
        this.player = player;
        this.pinPadAuthGUIConfiguration = pinPadAuthGUIConfiguration;
        this.inventory = Bukkit.createInventory(this, 54, ChatColor.translateAlternateColorCodes('&', pinPadAuthGUIConfiguration.getInventoryName()));
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    private void updateInventory() {
        this.inventory.setContents(getInventoryContents());
    }

    public void openInventory() {
        updateInventory();
        player.openInventory(inventory);
    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        int slot = inventoryClickEvent.getSlot();


        if (slot == 42) {
            StringBuilder stringBuilder = new StringBuilder();
            for (byte input : inputs) {
                stringBuilder.append(input);
            }
            int inputPin = Integer.parseInt(stringBuilder.toString());
            if (inputPin == generatedPin) {
                Bukkit.broadcastMessage("correct pin");
            } else {
                Bukkit.broadcastMessage("invalid pin");

            }

        }

        if (slot == 38) {
            Arrays.fill(inputs, (byte) -1);
            this.generatedPin = ThreadLocalRandom.current().nextInt(0, 99999);

        }
        byte pinNumber = -1;
        switch (slot) {
            case 12:
                pinNumber = 1;
                break;
            case 13:
                pinNumber = 2;
                break;
            case 14:
                pinNumber = 3;
                break;
            case 21:
                pinNumber = 4;
                break;
            case 22:
                pinNumber = 5;
                break;
            case 23:
                pinNumber = 6;
                break;
            case 30:
                pinNumber = 7;
                break;
            case 31:
                pinNumber = 8;
                break;
            case 32:
                pinNumber = 9;
                break;

        }
        if (pinNumber != -1) {
            tryAddInputNumber(pinNumber);
            updateInventory();
        }
        updateInventory();

    }

    private ItemStack[] getInventoryContents() {
        Inventory temp = Bukkit.createInventory(null, 54);
        Bukkit.broadcastMessage(String.valueOf(generatedPin));
            temp.setItem(4, pinPadAuthGUIConfiguration.getInformationHead().clone().replacePlaceHolder("%pin%", String.valueOf(generatedPin)).getItemStack());


        temp.setItem(12, pinPadAuthGUIConfiguration.getOneNumberHead().getItemStack());
        temp.setItem(13, pinPadAuthGUIConfiguration.getTwoNumberHead().getItemStack());
        temp.setItem(14, pinPadAuthGUIConfiguration.getThreeNumberHead().getItemStack());

        temp.setItem(21, pinPadAuthGUIConfiguration.getFourNumberHead().getItemStack());
        temp.setItem(22, pinPadAuthGUIConfiguration.getFiveNumberHead().getItemStack());
        temp.setItem(23, pinPadAuthGUIConfiguration.getSixNumberHead().getItemStack());

        temp.setItem(30, pinPadAuthGUIConfiguration.getSevenNumberHead().getItemStack());
        temp.setItem(31, pinPadAuthGUIConfiguration.getEightNumberHead().getItemStack());
        temp.setItem(32, pinPadAuthGUIConfiguration.getNineNumberHead().getItemStack());

        temp.setItem(38, pinPadAuthGUIConfiguration.getCancelHead().getItemStack());

        temp.setItem(42, pinPadAuthGUIConfiguration.getProceedHead().getItemStack());

        temp.setItem(47, getPinPreviewHead(0));
        temp.setItem(48, getPinPreviewHead(1));
        temp.setItem(49, getPinPreviewHead(2));
        temp.setItem(50, getPinPreviewHead(3));
        temp.setItem(51, getPinPreviewHead(4));

        return temp.getContents();
    }

    private void tryAddInputNumber(byte input) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == -1) {
                inputs[i] = input;
                return;
            }
        }
    }

    private ItemStack getPinPreviewHead(int index) {
        ItemStack questionMarkItem = pinPadAuthGUIConfiguration.getQuestionMarkHead().getItemStack();
        if (index > inputs.length - 1) return questionMarkItem;
        byte number = inputs[index];
        if (number == -1) return questionMarkItem;
        switch (number) {
            case 1:
                return pinPadAuthGUIConfiguration.getOneNumberHead().getItemStack();
            case 2:
                return pinPadAuthGUIConfiguration.getTwoNumberHead().getItemStack();
            case 3:
                return pinPadAuthGUIConfiguration.getThreeNumberHead().getItemStack();
            case 4:
                return pinPadAuthGUIConfiguration.getFourNumberHead().getItemStack();
            case 5:
                return pinPadAuthGUIConfiguration.getFiveNumberHead().getItemStack();
            case 6:
                return pinPadAuthGUIConfiguration.getSixNumberHead().getItemStack();
            case 7:
                return pinPadAuthGUIConfiguration.getSevenNumberHead().getItemStack();
            case 8:
                return pinPadAuthGUIConfiguration.getEightNumberHead().getItemStack();
            case 9:
                return pinPadAuthGUIConfiguration.getNineNumberHead().getItemStack();
        }
        return questionMarkItem;
    }
}
