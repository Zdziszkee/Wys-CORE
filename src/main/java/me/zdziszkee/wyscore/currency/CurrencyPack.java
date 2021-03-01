package me.zdziszkee.wyscore.currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyPack {

    private final Map<Integer, Integer> currencyValues = new HashMap<>();

    public int getAmount(CurrencyType currencyType) {
        return currencyValues.get(currencyType.getCurrencyID());
    }

    public void incrementAmount(CurrencyType currencyType, int amount) {
        int balance = getAmount(currencyType);
        currencyValues.put(currencyType.getCurrencyID(), amount + balance);

    }

    public void decrementAmount(CurrencyType currencyType, int amount) {
        int balance = getAmount(currencyType);
        currencyValues.put(currencyType.getCurrencyID(), balance - amount);
    }

    public void setAmount(CurrencyType currencyType, int amount) {
        currencyValues.put(currencyType.getCurrencyID(), amount);
    }

    public boolean containsCurrencyType(CurrencyType currencyType) {
        return currencyValues.containsKey(currencyType.getCurrencyID());
    }

    public void addCurrency(CurrencyType currencyType) {
        setAmount(currencyType, 0);
    }

}
