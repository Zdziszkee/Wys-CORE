package me.zdziszkee.wyscore.commands.test;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.auth.PinPadAuthGUI;
import me.zdziszkee.wyscore.configuration.PinPadAuthGUIConfiguration;
import org.bukkit.entity.Player;

@CommandAlias("test2")
@RequiredArgsConstructor
public class Test2 extends BaseCommand {
    private final PinPadAuthGUIConfiguration pinPadAuthGUIConfiguration;

    @Default
    public void onDefault(Player player) {
        PinPadAuthGUI pinPadAuthGUI = new PinPadAuthGUI(pinPadAuthGUIConfiguration, player);
        pinPadAuthGUI.openInventory();
    }
}
