package pl.carp.webapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Testing MongoDB repository configuration
 */
@Configuration
@Import({EmbeddedTestMongoConfiguration.class})
public class TestRepositoryConfiguration {
}