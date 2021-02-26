package me.zdziszkee.wyscore.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDB {
    private final String databaseURI;
    private final String dataBaseName;

    public MongoDB(String databaseURI, String dataBaseName) {
        this.databaseURI = databaseURI;
        this.dataBaseName = dataBaseName;
    }

    public void connect(){
        MongoClient mongoClient = MongoClients.create(databaseURI);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBaseName);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("currency");
    }
}
