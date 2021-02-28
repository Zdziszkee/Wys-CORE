package me.zdziszkee.wyscore.currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyPack {
    private final Map<CurrencyType, Integer> currencyValues = new HashMap<>();

    public int getAmount(CurrencyType currencyType) {
        return currencyValues.get(currencyType);
    }

    public void incrementAmount(CurrencyType currencyType, int amount) {
        int balance = getAmount(currencyType);
        currencyValues.put(currencyType, amount + balance);

    }

    public void decrementAmount(CurrencyType currencyType, int amount) {
        int balance = getAmount(currencyType);
        currencyValues.put(currencyType, balance - amount);
    }

    public void setAmount(CurrencyType currencyType, int amount) {
        currencyValues.put(currencyType, amount);
    }
    public boolean containsCurrencyType(CurrencyType currencyType){
        return currencyValues.containsKey(currencyType);
    }

}
