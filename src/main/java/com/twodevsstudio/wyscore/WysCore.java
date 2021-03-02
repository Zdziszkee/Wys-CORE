package com.twodevsstudio.wyscore;

import co.aikar.commands.PaperCommandManager;
import com.twodevsstudio.simplejsonconfig.SimpleJSONConfig;
import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.wyscore.commands.*;
import com.twodevsstudio.wyscore.commands.build.BuildCmd;
import com.twodevsstudio.wyscore.commands.build.BuildCommandManager;
import com.twodevsstudio.wyscore.commands.build.BuildListener;
import com.twodevsstudio.wyscore.commands.listeners.CommandPreProcessListener;
import com.twodevsstudio.wyscore.commands.protect.ProtectCmd;
import com.twodevsstudio.wyscore.commands.protect.ProtectedPlayerDamageListener;
import com.twodevsstudio.wyscore.commands.protect.ProtectedPlayersManager;
import com.twodevsstudio.wyscore.commands.teleport.*;
import com.twodevsstudio.wyscore.commands.vanish.VanishCmd;
import com.twodevsstudio.wyscore.commands.vanish.VanishedPlayersManager;
import com.twodevsstudio.wyscore.configuration.CommandConfiguration;
import com.twodevsstudio.wyscore.configuration.GeneralConfiguration;
import com.twodevsstudio.wyscore.database.MongoDB;
import com.twodevsstudio.wyscore.database.service.CurrencyService;
import com.twodevsstudio.wyscore.database.service.PlayerService;
import com.twodevsstudio.wyscore.listeners.PlayerJoinListener;
import com.twodevsstudio.wyscore.listeners.PlayerQuitListener;
import com.twodevsstudio.wyscore.time.PlayerJoinTimeManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WysCore extends JavaPlugin {
    private final BuildCommandManager buildCommandManager = new BuildCommandManager();
    private final ProtectedPlayersManager protectedPlayersManager = new ProtectedPlayersManager();
    private final TeleportDisabledPlayersManager teleportDisabledPlayersManager = new TeleportDisabledPlayersManager();
    private CommandConfiguration commandConfiguration;
    private GeneralConfiguration generalConfiguration;
    private MongoDB mongoDB;
    private CurrencyService currencyService;
    private PlayerService playerService;
    private final VanishedPlayersManager vanishedPlayersManager = new VanishedPlayersManager();
    private static WysCore wysCore;
    private final PlayerJoinTimeManager playerJoinTimeManager = new PlayerJoinTimeManager();
    @Override
    public void onEnable() {
        wysCore=this;
        SimpleJSONConfig.INSTANCE.register(this);
        commandConfiguration = Config.getConfig(CommandConfiguration.class);
        generalConfiguration = Config.getConfig(GeneralConfiguration.class);
        Bukkit.broadcastMessage("Wys-CORE has been enabled!");
        mongoDB = new MongoDB(generalConfiguration);
        mongoDB.connect();
        playerService= new PlayerService(mongoDB.getPlayerCollection());
        currencyService = new CurrencyService(mongoDB.getCurrencyCollection());
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
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(vanishedPlayersManager,generalConfiguration,playerJoinTimeManager),this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(playerJoinTimeManager,playerService),this);

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
        paperCommandManager.registerCommand(new GiveAllCmd(commandConfiguration));
        paperCommandManager.registerCommand(new GiveCmd(commandConfiguration));
        paperCommandManager.registerCommand(new HealCmd(commandConfiguration));
        paperCommandManager.registerCommand(new HealCmd(commandConfiguration));
        paperCommandManager.registerCommand(new HelpCmd(commandConfiguration));
        paperCommandManager.registerCommand(new InvseeCmd(commandConfiguration));
        paperCommandManager.registerCommand(new KillCmd(commandConfiguration));
        paperCommandManager.registerCommand(new OnlineListCmd());
        paperCommandManager.registerCommand(new PartnerCmd(commandConfiguration));
        paperCommandManager.registerCommand(new PingCommand(commandConfiguration));
        paperCommandManager.registerCommand(new ShopCommand(commandConfiguration));
        paperCommandManager.registerCommand(new SpeedCmd(commandConfiguration));
        paperCommandManager.registerCommand(new TimeRestartCmd(this, commandConfiguration));
        paperCommandManager.registerCommand(new VanishCmd(commandConfiguration,vanishedPlayersManager));
        paperCommandManager.registerCommand(new WhereAmICmd(commandConfiguration));
    }

    public static WysCore getInstance() {
        return wysCore;
    }

    public CurrencyService getCurrencyService() {
        return currencyService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }
}
