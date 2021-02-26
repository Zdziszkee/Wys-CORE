package me.zdziszkee.wyscore;

import co.aikar.commands.PaperCommandManager;
import com.twodevsstudio.simplejsonconfig.SimpleJSONConfig;
import com.twodevsstudio.simplejsonconfig.api.Config;
import me.zdziszkee.wyscore.commands.*;
import me.zdziszkee.wyscore.commands.build.BuildCmd;
import me.zdziszkee.wyscore.commands.build.BuildCommandManager;
import me.zdziszkee.wyscore.commands.build.BuildListener;
import me.zdziszkee.wyscore.commands.listeners.CommandPreProcessListener;
import me.zdziszkee.wyscore.commands.protect.ProtectCmd;
import me.zdziszkee.wyscore.commands.protect.ProtectedPlayerDamageListener;
import me.zdziszkee.wyscore.commands.protect.ProtectedPlayersManager;
import me.zdziszkee.wyscore.commands.teleport.*;
import me.zdziszkee.wyscore.commands.test.Test1;
import me.zdziszkee.wyscore.commands.test.Test2;
import me.zdziszkee.wyscore.commands.test.Test3;
import me.zdziszkee.wyscore.configuration.CommandConfiguration;
import me.zdziszkee.wyscore.configuration.PatternFinderAuthGUIConfiguration;
import me.zdziszkee.wyscore.configuration.PinPadAuthGUIConfiguration;
import me.zdziszkee.wyscore.configuration.PuzzleAuthGUIConfiguration;
import me.zdziszkee.wyscore.gui.GUIListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WysCore extends JavaPlugin {
    private final BuildCommandManager buildCommandManager = new BuildCommandManager();
    private final ProtectedPlayersManager protectedPlayersManager = new ProtectedPlayersManager();
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager = new TeleportDisabledPlayersManager();
    private CommandConfiguration commandConfiguration;
    private PatternFinderAuthGUIConfiguration patternFinderAuthGUIConfiguration;
    private PuzzleAuthGUIConfiguration puzzleAuthGUIConfiguration;
    private PinPadAuthGUIConfiguration pinPadAuthGUIConfiguration;

    @Override
    public void onEnable() {
        SimpleJSONConfig.INSTANCE.register(this);
        commandConfiguration = Config.getConfig(CommandConfiguration.class);
        patternFinderAuthGUIConfiguration = Config.getConfig(PatternFinderAuthGUIConfiguration.class);
        pinPadAuthGUIConfiguration = Config.getConfig(PinPadAuthGUIConfiguration.class);
        puzzleAuthGUIConfiguration = Config.getConfig(PuzzleAuthGUIConfiguration.class);

        Bukkit.broadcastMessage("Wys-CORE has been enabled!");
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        Bukkit.broadcastMessage("Wys-CORE has been disabled!");

    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new BuildListener(buildCommandManager), this);
        Bukkit.getPluginManager().registerEvents(new ProtectedPlayerDamageListener(protectedPlayersManager), this);
        Bukkit.getPluginManager().registerEvents(new CommandPreProcessListener(), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);

    }

    private void registerCommands() {
        PaperCommandManager paperCommandManager = new PaperCommandManager(this);
        paperCommandManager.registerCommand(new BuildCmd(buildCommandManager, commandConfiguration));
        paperCommandManager.registerCommand(new ProtectCmd(protectedPlayersManager, commandConfiguration));
        paperCommandManager.registerCommand(new SummonCmd(teleportDisabledPlayersManager, commandConfiguration));
        paperCommandManager.registerCommand(new TeleportAllCmd(teleportDisabledPlayersManager));
        paperCommandManager.registerCommand(new TeleportCmd(teleportDisabledPlayersManager, commandConfiguration));
        paperCommandManager.registerCommand(new TeleportToggleCmd(teleportDisabledPlayersManager, commandConfiguration));
        paperCommandManager.registerCommand(new AboutCmd(commandConfiguration));
        paperCommandManager.registerCommand(new BroadcastCmd(commandConfiguration));
        paperCommandManager.registerCommand(new BugCmd(commandConfiguration));
        paperCommandManager.registerCommand(new ClearChatCmd(commandConfiguration));
        paperCommandManager.registerCommand(new DiscordCmd(commandConfiguration));
        paperCommandManager.registerCommand(new FlyCommand(commandConfiguration));
        paperCommandManager.registerCommand(new FlyGiveAllCmd());
        paperCommandManager.registerCommand(new GiveAllCmd());
        paperCommandManager.registerCommand(new GiveCmd());
        paperCommandManager.registerCommand(new HealCmd());
        paperCommandManager.registerCommand(new HealCmd());
        paperCommandManager.registerCommand(new HelpCmd(commandConfiguration));
        paperCommandManager.registerCommand(new InvseeCmd());
        paperCommandManager.registerCommand(new KillCmd());
        paperCommandManager.registerCommand(new OnlineListCmd());
        paperCommandManager.registerCommand(new PartnerCmd(commandConfiguration));
        paperCommandManager.registerCommand(new PingCommand(commandConfiguration));
        paperCommandManager.registerCommand(new ShopCommand(commandConfiguration));
        paperCommandManager.registerCommand(new SpeedCmd());
        paperCommandManager.registerCommand(new TimeRestartCmd(this, commandConfiguration));
        paperCommandManager.registerCommand(new VanishCmd());
        paperCommandManager.registerCommand(new WhereAmICmd(commandConfiguration));
        paperCommandManager.registerCommand(new Test1(patternFinderAuthGUIConfiguration));
        paperCommandManager.registerCommand(new Test2(pinPadAuthGUIConfiguration));
        paperCommandManager.registerCommand(new Test3(puzzleAuthGUIConfiguration));

    }

}
