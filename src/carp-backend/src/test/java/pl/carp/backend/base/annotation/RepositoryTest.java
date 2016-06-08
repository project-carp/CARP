package pl.carp.backend.base.annotation;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import pl.carp.backend.configuration.TestRepositoryConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Repository Tests cumulative annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestPropertySource(locations = "classpath:application-test.yml")
@SpringApplicationConfiguration(classes = TestRepositoryConfiguration.class)
public @interface RepositoryTest {
}