package pl.carp.webapp.configuration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.carp.webapp.repository.ApplicationUserComplexRepository;
import pl.carp.webapp.repository.ApplicationUserRepository;
import pl.carp.webapp.repository.geo.JourneyRepository;

/**
 * Embedded MongoDB instance configuration
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = {
        JourneyRepository.class,
        ApplicationUserRepository.class
})
@ComponentScan(basePackageClasses = {
        ApplicationUserComplexRepository.class
})
public class EmbeddedTestMongoConfiguration extends AbstractMongoConfiguration {
    public static final String DB_NAME = "carp-integration-tests";
    public static final String FONGO_INSTANCE_NAME = "carp-in-memory-mongo";

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(FONGO_INSTANCE_NAME).getMongo();
    }

    @Bean
    public MongoTemplate mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, DB_NAME);
    }
}