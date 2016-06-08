package pl.carp.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.DispatcherServlet;
import pl.carp.backend.repository.ApplicationUserRepository;
import pl.carp.backend.repository.geo.JourneyRepository;
import pl.carp.common.version.Version;
import pl.carp.webapp.configuration.WebAppConfiguration;

/**
 * Simple Spring Boot's main class
 */
@SpringBootApplication
@Import({WebAppConfiguration.class})
@ComponentScan(basePackages={"pl.carp"})
@EnableMongoRepositories(basePackageClasses = {
        JourneyRepository.class,
        ApplicationUserRepository.class
})
public class CarpApplication {
    private static final Logger logger = LoggerFactory.getLogger(CarpApplication.class);

    public static void main(String... args) {
        logger.info("Carp Application '{}' is starting...", Version.VERSION);

        ConfigurableApplicationContext context = SpringApplication.run(CarpApplication.class, args);
        DispatcherServlet dispatcherServlet = (DispatcherServlet) context.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        logger.info("Carp Application is running!");
    }
}