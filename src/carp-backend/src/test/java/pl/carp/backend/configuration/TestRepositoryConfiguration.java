package pl.carp.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Testing MongoDB repository configuration
 */
@Configuration
@Import({EmbeddedTestMongoConfiguration.class})
public class TestRepositoryConfiguration {
}