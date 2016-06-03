package pl.carp.webapp.configuration.annotation;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.carp.webapp.CarpApplication;
import pl.carp.webapp.configuration.TestWebConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@DefaultTest
@WebAppConfiguration
@SpringApplicationConfiguration(classes = {CarpApplication.class, TestWebConfiguration.class})
public @interface DefaultWebTest {
}