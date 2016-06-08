package pl.carp.webapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * AOP Configuration
 */
@Configuration
@ComponentScan(basePackages = {"pl.carp"})
@EnableMongoRepositories(basePackages = "pl.carp.backend.repository")
@EnableAspectJAutoProxy
public class WebAppConfiguration {
}