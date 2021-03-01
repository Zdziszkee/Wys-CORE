package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;
import me.zdziszkee.wyscore.currency.CurrencyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Configuration(name = "generalConfiguration.json")
public class GeneralConfiguration extends Config {
    private String mongoURI = "put-your-uri there";
    private String mongoDatabaseName = "database name";
    private List<CurrencyType> currencyTypes = new ArrayList<>();

    public GeneralConfiguration() {
        currencyTypes.add(new CurrencyType(1, "money"));
        currencyTypes.add(new CurrencyType(2, "bezants"));
        currencyTypes.add(new CurrencyType(3, "treasure keys"));
    }

    public Optional<CurrencyType> getCurrencyTypeFromName(String name) {
        return currencyTypes.stream().filter(currencyType -> currencyType.getCurrencyName().equals(name)).findFirst();
    }

}
