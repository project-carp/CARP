package pl.carp.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import pl.carp.common.version.Version;

/**
 * Simple Spring Boot's main class
 */
@SpringBootApplication
public class CarpApplication {
    private static final Logger logger = LoggerFactory.getLogger(CarpApplication.class);

    public static void main(String... args) {
        logger.info("Carp Application '{}' is starting...", Version.getVersion());

        ConfigurableApplicationContext context = SpringApplication.run(CarpApplication.class, args);
        DispatcherServlet dispatcherServlet = (DispatcherServlet) context.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        logger.info("Carp Application is running!");
    }
}