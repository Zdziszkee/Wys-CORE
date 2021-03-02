package com.twodevsstudio.wyscore.api;

import com.twodevsstudio.wyscore.WysCore;
import com.twodevsstudio.wyscore.database.service.CurrencyService;
import com.twodevsstudio.wyscore.database.service.PlayerService;

public class CoreAPI {
    public static PlayerService getPlayerService(){
        return WysCore.getInstance().getPlayerService();
    }
    public static CurrencyService getCurrencyService(){
        return WysCore.getInstance().getCurrencyService();
    }
}
