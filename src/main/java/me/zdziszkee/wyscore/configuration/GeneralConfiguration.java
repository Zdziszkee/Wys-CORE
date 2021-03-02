package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Configuration("generalConfiguration.json")
public class GeneralConfiguration extends Config {
    private String mongoURI = "mongodb+srv://zdziszkee:feedforafrica@cluster0.acoet.gcp.mongodb.net/RPG?retryWrites=true&w=majority";

}
