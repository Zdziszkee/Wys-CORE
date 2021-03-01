package me.zdziszkee.wyscore.api;

import me.zdziszkee.wyscore.WysCore;
import me.zdziszkee.wyscore.database.service.CurrencyService;
import me.zdziszkee.wyscore.database.service.PlayerService;

public class CoreAPI {
    public static PlayerService getPlayerService(){
        return WysCore.getInstance().getPlayerService();
    }
    public static CurrencyService getCurrencyService(){
        return WysCore.getInstance().getCurrencyService();
    }
}
