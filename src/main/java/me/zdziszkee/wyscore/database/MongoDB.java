package me.zdziszkee.wyscore.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MongoDB {
    private final String databaseURI;
    private final String dataBaseName;
    MongoCollection<Document> currencyCollection;
    MongoCollection<Document> playerCollection;
    public MongoDB(String databaseURI, String dataBaseName) {
        this.databaseURI = databaseURI;
        this.dataBaseName = dataBaseName;
    }

    public void connect(){
        MongoClient mongoClient = MongoClients.create(databaseURI);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBaseName);
        currencyCollection = mongoDatabase.getCollection("currency");
        playerCollection = mongoDatabase.getCollection("playerCollection");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Connected to mongodb!");
    }

    public MongoCollection<Document> getCurrencyCollection() {
        return currencyCollection;
    }
}
