package com.twodevsstudio.wyscore.time;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerJoinTimeManager {
    private final Map<UUID, Long> playerTimeJoinedMap = new HashMap<>();

    public void getJoinTime(Player player) {
        playerTimeJoinedMap.get(player.getUniqueId());
    }
    public long getOnlineTime(Player player){
       return playerTimeJoinedMap.get(player.getUniqueId());
    }
    public void addPlayer(Player player) {
        playerTimeJoinedMap.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public long getTimeOnline(Player player) {
        return System.currentTimeMillis()-playerTimeJoinedMap.get(player.getUniqueId());
    }

    public void removePlayer(Player player) {
        playerTimeJoinedMap.remove(player.getUniqueId());
    }

}
