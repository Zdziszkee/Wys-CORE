package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@Configuration(name = "commands.json")
public class CommandConfiguration extends Config {
    private final List<String> clearChatCommandMessage = Collections.singletonList("Chat has been cleared");
    private final List<String> aboutCommandMessage = Collections.singletonList("website: www.example.com");
    private final List<String> bugCommandMessage = Collections.singletonList("report bugs on our website");
    private final List<String> helpCommandMessage = Collections.singletonList("help examples");
    private final List<String> buildCommandEnableMessage = Collections.singletonList("building has been enabled");
    private final List<String> buildCommandDisableMessage = Collections.singletonList("building has been disabled");
    private final List<String> selfClearInventoryCommandMessage = Collections.singletonList("Your inventory has been cleared");
    private final List<String> clearInventoryCommandMessage = Collections.singletonList("Inventory of %player% has been cleared");
    private final List<String> discordCommandMessage = Collections.singletonList("your discord link!");
    private final List<String> playerNotFoundMessage = Collections.singletonList("player not found!");
    private final List<String> doNotHavePermissionMessage = Collections.singletonList("you do not have permission to do that!");
    private final List<String> onlineCommandMessage = Collections.singletonList("player amount: %amount%");
    private final List<String> partnerCommandMessage = Collections.singletonList("your message there");
    private final List<String> pingCommandMessage = Collections.singletonList("This player ping is %amount%");
    private final List<String> protectCommandDisableMessage = Collections.singletonList("You are no longer protected!");
    private final List<String> protectCommandEnableMessage = Collections.singletonList("You are protected!");
    private final List<String> shopCommandMessage = Collections.singletonList("you stuff there!");
    private final List<String> serverRestartCommandMessage = Collections.singletonList("Restarting in %amount%!");
    private final List<String> whereAmICommandMessage = Collections.singletonList("Your are on %server%!");
    private final List<String> thisPlayerHasDisabledTeleportingMessage = Collections.singletonList("This player has disabled teleporting");
    private final List<String> selfTeleportingEnabledMessage = Collections.singletonList("Teleporting has been enabled");
    private final List<String> selfTeleportingDisabledMessage = Collections.singletonList("Teleporting has been disabled");
    private final List<String> teleportingEnabledMessage = Collections.singletonList("Teleporting of %player% has been enabled");
    private final List<String> teleportingDisabledMessage = Collections.singletonList("Teleporting of %player% has been disabled");
    private final List<String> youMustProvideANumberMessage = Collections.singletonList("You must provide a number!");
    private final List<String> invalidMaterialMessage = Collections.singletonList("%input% is not a valid material");

}
