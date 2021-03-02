package me.zdziszkee.wyscore.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import me.zdziszkee.wyscore.configuration.GeneralConfiguration;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

@RequiredArgsConstructor
public class MongoDB {
    private final GeneralConfiguration generalConfiguration;
    MongoCollection<Document> currencyCollection;
    MongoCollection<Document> playerCollection;


    public void connect() {

        String mongoURI = generalConfiguration.getMongoURI();
        if(mongoURI.isEmpty()){
            Bukkit.getConsoleSender().sendMessage("[Core] Database not found, check connection string in config!");
            return;
        }
        MongoClient mongoClient = MongoClients.create(mongoURI);
        String first = mongoClient.listDatabaseNames().first();
        if (first == null) {
            Bukkit.getConsoleSender().sendMessage("[Core] Database not found!");
            return;
        }
        MongoDatabase mongoDatabase = mongoClient.getDatabase(first);


        currencyCollection = mongoDatabase.getCollection("currency");
        playerCollection = mongoDatabase.getCollection("playerCollection");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Connected to mongodb!");
    }

    public MongoCollection<Document> getPlayerCollection() {
        return playerCollection;
    }

    public MongoCollection<Document> getCurrencyCollection() {
        return currencyCollection;
    }
}
