package me.zdziszkee.wyscore.commands.test;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.auth.PuzzleAuthGUI;
import me.zdziszkee.wyscore.configuration.PuzzleAuthGUIConfiguration;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@CommandAlias("test3")
public class Test3 extends BaseCommand {
    private final PuzzleAuthGUIConfiguration puzzleAuthGUIConfiguration;

    @Default
    public void onDefault(Player player) {
        PuzzleAuthGUI puzzleAuthGUI = new PuzzleAuthGUI(player, puzzleAuthGUIConfiguration);
        puzzleAuthGUI.openInventory();
    }
}
