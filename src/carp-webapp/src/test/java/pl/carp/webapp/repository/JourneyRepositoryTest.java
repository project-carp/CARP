package pl.carp.webapp.repository;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.carp.webapp.configuration.TestRepositoryConfiguration;
import pl.carp.webapp.configuration.annotation.DefaultTest;
import pl.carp.webapp.model.entity.geo.Journey;
import pl.carp.webapp.repository.geo.JourneyRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Simple integration test with Embedded MongoDB instance
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestRepositoryConfiguration.class)
@DefaultTest
public class JourneyRepositoryTest {
    public static final Logger log = LoggerFactory.getLogger(JourneyRepositoryTest.class);

    @Autowired
    private JourneyRepository journeyRepository;

    @Test
    public void shouldNotFindAnyJourneys() {
        String userName = "notExistingUser";

        List<Journey> result = journeyRepository.findByUserName(userName);

        assertEquals(0, result.size());
        log.debug("Result size = '{}'", result.size());
    }

    @Test
    @UsingDataSet(locations = {"/two-journeys.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void shouldHaveSomeEntries() {
        // TODO: implement this test...
    }
}