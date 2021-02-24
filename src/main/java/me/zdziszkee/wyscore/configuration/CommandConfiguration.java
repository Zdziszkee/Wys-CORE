package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@Configuration(name="commands.json")
public class CommandConfiguration {
private List<String> clearChatCommandMessage = Collections.singletonList("Chat has been cleared");
private List<String> aboutCommandMessage = Collections.singletonList("website: www.example.com");
private List<String> bugCommandMessage= Collections.singletonList("report bugs on our website");
private List<String> helpCommandMessage= Collections.singletonList("help examples");
private List<String> buildCommandEnableMessage = Collections.singletonList("building has been enabled");
private List<String> buildCommandDisableMessage = Collections.singletonList("building has been disabled");
private List<String> clearInventoryCommandMessage = Collections.singletonList("Your inventory has been cleared");
private List<String> clearInventoryCommandPlayerNotFoundMessage = Collections.singletonList("this player is not online!");
private List<String> discordCommandMessage = Collections.singletonList("your discord link!");
private List<String> flyCommandPlayerNotFoundMessage = Collections.singletonList("player not found!");
private List<String> onlineCommandMessage = Collections.singletonList("player amount: %amount%");
private List<String> partnerCommandMessage = Collections.singletonList("your message there");
private List<String> pingCommandMessage = Collections.singletonList("This player ping is %amount%");
private List<String> protectCommandDisableMessage = Collections.singletonList("You are no longer protected!");
private List<String> protectCommandEnableMessage = Collections.singletonList("You are protected!");
private List<String> shopCommandMessage = Collections.singletonList("you stuff there!");
private List<String> serverRestartCommandMessage = Collections.singletonList("Restarting in %amount%!");
private List<String> whereAmICommandMessage = Collections.singletonList("Your are on %server%!");

}
