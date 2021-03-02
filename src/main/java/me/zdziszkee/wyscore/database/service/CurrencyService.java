package me.zdziszkee.wyscore.database.service;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.currency.CurrencyPack;
import org.bson.Document;

import java.util.UUID;

@RequiredArgsConstructor
public class CurrencyService {
    private final MongoCollection<Document> currencyCollection;
    private final Gson gson = new Gson();

    public void save(UUID uuid, CurrencyPack currencyPack) {
        Document document = Document.parse(gson.toJson(currencyPack)).append("player", uuid.toString());
        currencyCollection.insertOne(document);
    }

    public void update(UUID uuid, CurrencyPack currencyPack) {
        Document document = Document.parse(gson.toJson(currencyPack)).append("player", uuid.toString());
        Document target = new Document("player",uuid.toString());
        currencyCollection.updateOne(target,document);
    }

    public CurrencyPack findByUUID(UUID uuid) {
        Document document = new Document("player", uuid.toString());
        FindIterable<Document> documents = currencyCollection.find(document);
        Document first = documents.first();
        if (first == null) return null;
        first.remove("player");
        return gson.fromJson(first.toJson(), CurrencyPack.class);
    }
    public void delete(UUID uuid){
        Document document = new Document("player", uuid.toString());
        currencyCollection.deleteOne(document);
    }

}
