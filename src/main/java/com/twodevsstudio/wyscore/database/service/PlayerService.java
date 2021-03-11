package com.twodevsstudio.wyscore.database.service;


import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


@RequiredArgsConstructor
public class PlayerService {
    private final MongoCollection<Document> playerCollection;
    private final Map<UUID, PlayerData> playerDataCache = new HashMap<>();
    
    public void save(UUID uuid) {
        
        PlayerData playerData = playerDataCache.get(uuid);
        Document document = new Document("player", uuid.toString()).append("firstJoinTime", playerData.getFirstJoinTime().toString())
                .append("onlineTimeInMillis", playerData.getOnlineTimeInMillis())
                .append("isAuthorizationComplete", playerData.isAuthorizationComplete())
                .append("isBoy",playerData.isBoy());
        playerCollection.insertOne(document);
    }
    
    public void update(UUID uuid) {
        
        PlayerData playerData = playerDataCache.get(uuid);
        Bson filter = eq("player", uuid.toString());
        Bson update1 = set("firstJoinTime", playerData.getFirstJoinTime().toString());
        Bson update4 = set("isBoy",playerData.isBoy());
        Bson update2 = set("onlineTimeInMillis", playerData.getOnlineTimeInMillis());
        Bson update3 = set("isAuthorizationComplete", playerData.isAuthorizationComplete());
        playerCollection.updateOne(filter, Updates.combine(update1, update2, update3,update4));
    }
    
    public PlayerData findByUUID(UUID uuid) {
        
        PlayerData playerData = playerDataCache.get(uuid);
        if (playerData != null) {
            return playerData;
        }
        Document document = new Document("player", uuid.toString());
        FindIterable<Document> documents = playerCollection.find(document);
        Document first = documents.first();
        if (first == null) {
            PlayerData data = new PlayerData(LocalDate.now(), 0, true, false);
            playerDataCache.put(uuid, data);
            save(uuid);
            return data;
        }
        first.remove("player");
        
        PlayerData found = new PlayerData(LocalDate.parse(first.getString("firstJoinTime")),first.getLong("onlineTimeInMillis"),first.getBoolean(
                "isBoy"),
                first.getBoolean(
                "isAuthorizationComplete"));
        playerDataCache.put(uuid, found);
        return found;
    }
    
    public void delete(UUID uuid) {
        
        Document document = new Document("player", uuid.toString());
        playerCollection.deleteOne(document);
    }
    
    public void removeFromCache(UUID uuid) {
        
        playerDataCache.remove(uuid);
    }
    
    @Getter
    @Setter
    @AllArgsConstructor
    public static class PlayerData {
        private LocalDate firstJoinTime;
        private long onlineTimeInMillis;
        private boolean isBoy;
        private boolean isAuthorizationComplete;
        
    }
}
