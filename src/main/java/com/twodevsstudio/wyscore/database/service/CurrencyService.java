package com.twodevsstudio.wyscore.database.service;


import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.twodevsstudio.wyscore.currency.CurrencyPack;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


@RequiredArgsConstructor
public class CurrencyService {
    private final Map<UUID, CurrencyPack> currencyPackCache = new HashMap<>();
    private final MongoCollection<Document> currencyCollection;
    private final Gson gson = new Gson();
    
    public void save(UUID uuid) {
        
        Document document = Document.parse(gson.toJson(currencyPackCache.get(uuid))).append("player", uuid.toString());
        currencyCollection.insertOne(document);
    }
    
    public void update(UUID uuid) {
        
        CurrencyPack currencyPack = currencyPackCache.get(uuid);
        Bson filter = eq("player", uuid.toString());
        Bson update1 = set("keys", currencyPack.getKeys());
        Bson update2 = set("money", currencyPack.getMoney());
        Bson update3 = set("bezants", currencyPack.getBezants());
        currencyCollection.updateOne(filter, Updates.combine(update1,update2,update3));
    }
    
    public CurrencyPack findByUUID(UUID uuid) {
        
        CurrencyPack currencyPack = currencyPackCache.get(uuid);
        if (currencyPack != null) {
            return currencyPack;
        }
        Document document = new Document("player", uuid.toString());
        FindIterable<Document> documents = currencyCollection.find(document);
        Document first = documents.first();
        if (first == null) {
            CurrencyPack value = new CurrencyPack(0, 0, 0);
            currencyPackCache.put(uuid, value);
            save(uuid);
            return value;
        }
        first.remove("player");
        CurrencyPack found = gson.fromJson(first.toJson(), CurrencyPack.class);
        currencyPackCache.put(uuid, found);
        return found;
    }
    
    public void delete(UUID uuid) {
        
        Document document = new Document("player", uuid.toString());
        currencyCollection.deleteOne(document);
        currencyPackCache.remove(uuid);
    }
    
    public void removeFromCache(UUID uuid) {
        
        currencyPackCache.remove(uuid);
    }
    
}
