package pl.carp.webapp.configuration;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Embedded MongoDB instance configuration
 */
@Configuration
public class EmbeddedTestMongoConfiguration {
    public static final String DB_NAME = "carp-integration-tests";
    public static final String FONGO_INSTANCE_NAME = "carp-in-memory-mongo";

    @Bean(name = "fongo")
    public Fongo getFongo() {
        return new Fongo(FONGO_INSTANCE_NAME);
    }

    @Bean(name = "mongo")
    public MongoClient getMongo(Fongo fongo) {
        return fongo.getMongo();
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate getMongoTemplate(MongoClient mongo) {
        return new MongoTemplate(mongo, DB_NAME);
    }
}
