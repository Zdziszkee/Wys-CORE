package me.zdziszkee.wyscore.database.service;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
public class PlayerService {
    private final MongoCollection<Document> playerCollection;
    private final Gson gson = new Gson();

    public void save(UUID uuid, PlayerData playerData) {
        Document document = Document.parse(gson.toJson(playerData)).append("player", uuid.toString());
        playerCollection.insertOne(document);
    }

    public void update(UUID uuid, PlayerData playerData) {
        Document document = Document.parse(gson.toJson(playerData)).append("player", uuid.toString());
        Document target = new Document("player", uuid.toString());
        playerCollection.updateOne(target, document);
    }

    public PlayerData findByUUID(UUID uuid) {
        Document document = new Document("player", uuid.toString());
        FindIterable<Document> documents = playerCollection.find(document);
        Document first = documents.first();
        if (first == null) return null;
        first.remove("player");
        return gson.fromJson(first.toJson(),PlayerData.class);
    }
    public void delete(UUID uuid){
        Document document = new Document("player", uuid.toString());
        playerCollection.deleteOne(document);
    }

    @Getter
    @Setter
    @AllArgsConstructor
  public  static class PlayerData {
        private LocalDate firstJoinTime;
        private long onlineTimeInMillis;
        private boolean isBoy;
        private boolean isAuthorizationComplete;

    }
}
