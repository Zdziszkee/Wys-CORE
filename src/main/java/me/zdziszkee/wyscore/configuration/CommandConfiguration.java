package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@Configuration("commands.json")
public class CommandConfiguration extends Config {
    private  List<String> clearChatCommandMessage = Collections.singletonList("Chat has been cleared");
    private  List<String> aboutCommandMessage = Collections.singletonList("website: www.example.com");
    private  List<String> bugCommandMessage = Collections.singletonList("report bugs on our website");
    private  List<String> helpCommandMessage = Collections.singletonList("help examples");
    private  List<String> buildCommandEnableMessage = Collections.singletonList("building has been enabled");
    private  List<String> buildCommandDisableMessage = Collections.singletonList("building has been disabled");
    private  List<String> selfClearInventoryCommandMessage = Collections.singletonList("Your inventory has been cleared");
    private  List<String> clearInventoryCommandMessage = Collections.singletonList("Inventory of %player% has been cleared");
    private  List<String> discordCommandMessage = Collections.singletonList("your discord link!");
    private  List<String> playerNotFoundMessage = Collections.singletonList("player not found!");
    private  List<String> doNotHavePermissionMessage = Collections.singletonList("you do not have permission to do that!");
    private  List<String> onlineCommandMessage = Collections.singletonList("player amount: %amount%");
    private  List<String> partnerCommandMessage = Collections.singletonList("your message there");
    private  List<String> pingCommandMessage = Collections.singletonList("This player ping is %amount%");
    private  List<String> protectCommandDisableMessage = Collections.singletonList("You are no longer protected!");
    private  List<String> protectCommandEnableMessage = Collections.singletonList("You are protected!");
    private  List<String> protectSomeoneCommandDisableMessage = Collections.singletonList("%player% is no longer protected!");
    private  List<String> protectSomeoneEnableMessage = Collections.singletonList("%player% is protected!");
    private  List<String> selfFlyEnableCommandMessage = Collections.singletonList("Fly has been enabled!");
    private  List<String> selfFlyDisableCommandMessage = Collections.singletonList("Fly has been disabled!");
    private  List<String> someoneFlyEnableCommandMessage = Collections.singletonList("%player%'s fly has been enabled");
    private  List<String> someoneFlyDisableCommandMessage = Collections.singletonList("%player%'s fly has been disabled");
    private  List<String> shopCommandMessage = Collections.singletonList("you stuff there!");
    private  List<String> serverRestartCommandMessage = Collections.singletonList("Restarting in %amount%!");
    private  List<String> whereAmICommandMessage = Collections.singletonList("Your are on %server%!");
    private  List<String> thisPlayerHasDisabledTeleportingMessage = Collections.singletonList("This player has disabled teleporting");
    private  List<String> selfTeleportingEnabledMessage = Collections.singletonList("Teleporting has been enabled");
    private  List<String> selfTeleportingDisabledMessage = Collections.singletonList("Teleporting has been disabled");
    private  List<String> teleportingEnabledMessage = Collections.singletonList("Teleporting of %player% has been enabled");
    private  List<String> teleportingDisabledMessage = Collections.singletonList("Teleporting of %player% has been disabled");
    private  List<String> youMustProvideANumberMessage = Collections.singletonList("You must provide a number!");
    private  List<String> invalidMaterialMessage = Collections.singletonList("%material% is not a valid material");
    private  List<String> selfHealCommandMessage = Collections.singletonList("healed!");
    private  List<String> someoneHealCommandMessage = Collections.singletonList("%player% has been healed!");
    private  List<String> selfVanishEnableCommandMessage = Collections.singletonList("Vanish has been enabled!");
    private  List<String> selfVanishDisableCommandMessage = Collections.singletonList("Vanish has been disabled!");
    private  List<String> someoneVanishEnableCommandMessage = Collections.singletonList("%player%'s vanish has been enabled!");
    private  List<String> someoneVanishDisableCommandMessage = Collections.singletonList("%player%'s vanish has been disabled!");
    private  List<String> selfKillCommandMessage = Collections.singletonList("You killed yourself");
    private  List<String> someoneKillCommandMessage = Collections.singletonList("%player% has been killed");
    private  List<String> summonCommandMessage = Collections.singletonList("%player% has been summoned");
    private  List<String> teleportCommandMessage = Collections.singletonList("%player% has been teleported to %target%");

}
