package me.zdziszkee.wyscore.currency;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class CurrencyService {
    private final Map<UUID, CurrencyPack> cache = new HashMap<>();
    private final MongoCollection<Document> currencyCollection;
    private final Gson gson = new Gson();

    public void save(UUID uuid, CurrencyPack currencyPack) {
        cache.put(uuid,currencyPack);
        Document document = Document.parse(gson.toJson(currencyPack)).append("player", uuid);
        currencyCollection.insertOne(document);
    }

    public void update(UUID uuid, CurrencyPack currencyPack) {
        Document document = Document.parse(gson.toJson(currencyPack)).append("player", uuid);
        Document target = new Document("player",uuid);
        currencyCollection.updateOne(target,document);
    }

    public CurrencyPack findByUUID(UUID uuid) {
        if (cache.containsKey(uuid)) {
            return cache.get(uuid);
        }
        Document document = new Document("player", uuid);
        FindIterable<Document> documents = currencyCollection.find(document);
        Document first = documents.first();
        if (first == null) return null;
        first.remove("player");
        CurrencyPack currencyPack = gson.fromJson(first.toJson(), CurrencyPack.class);
        cache.put(uuid, currencyPack);
        return currencyPack;
    }

}
