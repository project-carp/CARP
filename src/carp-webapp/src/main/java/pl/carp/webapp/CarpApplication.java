package pl.carp.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.DispatcherServlet;
import pl.carp.common.version.Version;
import pl.carp.webapp.configuration.WebAppConfiguration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Simple Spring Boot's main class
 */
@SpringBootApplication
@Import({WebAppConfiguration.class})
public class CarpApplication {
    private static final Logger log = LoggerFactory.getLogger(CarpApplication.class);

    public static void main(String... args) throws UnknownHostException {
        log.info("Carp Application '{}' is starting...", Version.VERSION);

        ConfigurableApplicationContext context = SpringApplication.run(CarpApplication.class, args);
        DispatcherServlet dispatcherServlet = (DispatcherServlet) context.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        logStartupInformations(context.getEnvironment());
    }

    private static void logStartupInformations(Environment environment) throws UnknownHostException {
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                environment.getProperty("spring.application.name"),
                environment.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                environment.getProperty("server.port"));
    }
}