package me.zdziszkee.wyscore.commands.test;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.AllArgsConstructor;
import me.zdziszkee.wyscore.auth.PatternFinderAuthGUI;
import me.zdziszkee.wyscore.configuration.PatternFinderAuthGUIConfiguration;
import org.bukkit.entity.Player;
@AllArgsConstructor
@CommandAlias("test1")
public class Test1 extends BaseCommand {
   private final PatternFinderAuthGUIConfiguration patternFinderAuthGUIConfiguration;
    @Default
    public void  onDefault(Player player){
        PatternFinderAuthGUI patternFinderAuthGUI = new PatternFinderAuthGUI(player,patternFinderAuthGUIConfiguration);
        patternFinderAuthGUI.openInventory();
    }
}
