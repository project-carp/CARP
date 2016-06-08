package pl.carp.backend.base;

import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import pl.carp.backend.configuration.EmbeddedTestMongoConfiguration;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder.newInMemoryMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Base for any Repository related test
 */
public abstract class BaseRepositoryTest {

    @ClassRule
    public static InMemoryMongoDb inMemoryMongoDb = newInMemoryMongoDbRule().build();   // build InMemory MongoDB instance rule

    @Rule
    public MongoDbRule embeddedMongoDbRule = newMongoDbRule().defaultSpringMongoDb(EmbeddedTestMongoConfiguration.DB_NAME);    // build Spring Data 'context' connected to InMemory MongoDB

    @Autowired
    protected ApplicationContext applicationContext;  // required by nosql-unit
}