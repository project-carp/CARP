package pl.carp.webapp.base;

import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder.newInMemoryMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static pl.carp.webapp.configuration.EmbeddedTestMongoConfiguration.DB_NAME;

/**
 * Base for any Repository related test
 */
public abstract class BaseRepositoryTest {

    @ClassRule
    public static InMemoryMongoDb inMemoryMongoDb = newInMemoryMongoDbRule().build();   // build InMemory MongoDB instance rule

    @Rule
    public MongoDbRule embeddedMongoDbRule = newMongoDbRule().defaultSpringMongoDb(DB_NAME);    // build Spring Data 'context' connected to InMemory MongoDB

    @Autowired
    protected ApplicationContext applicationContext;  // required by nosql-unit
}