package me.zdziszkee.wyscore.configuration;

import com.twodevsstudio.simplejsonconfig.api.Config;
import com.twodevsstudio.simplejsonconfig.interfaces.Configuration;
import lombok.Getter;
import me.zdziszkee.wyscore.gui.GUISkull;

@Getter
@Configuration(name = "puzzleauthgui.json")
public class PuzzleAuthGUIConfiguration extends Config {
    private String inventoryName = "example";
    private GUISkull cancelHead = new GUISkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmViNTg4YjIxYTZmOThhZDFmZjRlMDg1YzU1MmRjYjA1MGVmYzljYWI0MjdmNDYwNDhmMThmYzgwMzQ3NWY3In19fQ==", "&cCancel", "lore");
    private GUISkull proceedHead = new GUISkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTYzMzlmZjJlNTM0MmJhMThiZGM0OGE5OWNjYTY1ZDEyM2NlNzgxZDg3ODI3MmY5ZDk2NGVhZDNiOGFkMzcwIn19fQ==", "PROCEED", "lore");
    private GUISkull informationHead = new GUISkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYThmN2YxNjIzNWRmMjI3YTZhMTk4ZGM5YTAxNDlmZmM2NmU5Y2ZmMGUwN2ZhYzIzODE3YzBiOWU4MTI2Y2NiOSJ9fX0=", "information", "lore");
}
