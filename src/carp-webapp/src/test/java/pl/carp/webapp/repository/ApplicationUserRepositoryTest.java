package pl.carp.webapp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.carp.webapp.CarpApplication;
import pl.carp.webapp.configuration.EmbeddedTestMongoConfiguration;
import pl.carp.webapp.model.ApplicationUser;

import static junit.framework.Assert.assertEquals;

/**
 * Simple integration test with Embedded MongoDB instance
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CarpApplication.class, EmbeddedTestMongoConfiguration.class})
public class ApplicationUserRepositoryTest {
    public static final Logger log = LoggerFactory.getLogger(ApplicationUserRepositoryTest.class);

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private ApplicationUserComplexRepository complexRepository;

    @Test
    public void shouldCreateUser() {
        ApplicationUser user = new ApplicationUser();
        user.setUserName("testUser");
        user.setPassword("123");

        ApplicationUser createdUser = userRepository.save(user);

        assertEquals(user.getUserName(), createdUser.getUserName());
        assertEquals(user.getPassword(), createdUser.getPassword());

        log.debug("Checked simple Repository.");
    }

    @Test
    public void shouldCreateUserByComplexRepository() {
        ApplicationUser user = new ApplicationUser();
        user.setUserName("testUser2");
        user.setPassword("124");

        ApplicationUser createdUser = complexRepository.save(user);

        assertEquals(user.getUserName(), createdUser.getUserName());
        assertEquals(user.getPassword(), createdUser.getPassword());

        log.debug("Checked complex Repository.");
    }
}