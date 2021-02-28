package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;
import me.zdziszkee.wyscore.currency.CurrencyType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Configuration(name = "generalConfiguration.json")
public class GeneralConfiguration extends Config {
private String mongoURI = "put-your-uri there";
private String mongoDatabaseName = "database name";
private List<CurrencyType> currencyTypes = new ArrayList<>();

    public GeneralConfiguration() {
        currencyTypes.add(new CurrencyType(1,"token"));
        currencyTypes.add(new CurrencyType(2,"money"));
        currencyTypes.add(new CurrencyType(3,"credits"));
    }



}
