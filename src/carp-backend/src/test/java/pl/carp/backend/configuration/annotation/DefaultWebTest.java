package pl.carp.backend.configuration.annotation;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.carp.backend.configuration.TestWebConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@DefaultTest
@WebAppConfiguration
@SpringApplicationConfiguration(classes = {TestWebConfiguration.class})
public @interface DefaultWebTest {
}