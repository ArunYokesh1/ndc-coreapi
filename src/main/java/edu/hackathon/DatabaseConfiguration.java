/**
 * 
 */
package edu.hackathon;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ArunYokesh1
 *
 */
//@Configuration
public class DatabaseConfiguration {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Value("${mongodb.uri}")
    private String mongoDBLocalURI;
    
   /* @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = null;
        String mongoDBURI = System.getenv("SCALINGO_MONGO_URL");
        boolean isLocalDB = false;
        if (null == mongoDBURI || mongoDBURI.equals("")) {
            mongoDBURI = mongoDBLocalURI;
            isLocalDB = true;
        }
        //MongoClientURI mongoClientURI = new MongoClientURI(mongoDBURI);
        MongoURI mongouri = new MongoURI(mongoDBURI);
        Mongo mongo = new Mongo(mongouri);
        if (!isLocalDB) {
            UserCredentials userCredentials = new UserCredentials(mongouri.getUsername(), mongouri.getPassword().toString());
            mongoTemplate = new MongoTemplate(mongo, mongouri.getDatabase(), userCredentials);
        } else {
            mongoTemplate = new MongoTemplate(mongo, mongouri.getDatabase());
        }
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);
        LOGGER.debug("Cleaning up Location collection from database");
        mongoTemplate.remove(new Query(), User.class);
        
        BasicDBObject basicDBObject  = new BasicDBObject();
        basicDBObject.put("coordinate", "2dsphere");
        mongoTemplate.getDb().getCollection(mongoTemplate.getCollectionName(Location.class)).createIndex(basicDBObject);
        
        mongoTemplate.remove(new Query(), Community.class);
       
        
      //  mongoTemplate.remove(new Query(), Shop.class);
       
        return mongoTemplate;*/
    //}
}
