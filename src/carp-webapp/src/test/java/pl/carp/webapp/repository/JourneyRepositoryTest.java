package pl.carp.webapp.repository;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.carp.webapp.base.BaseRepositoryTest;
import pl.carp.webapp.configuration.TestRepositoryConfiguration;
import pl.carp.webapp.configuration.annotation.DefaultTest;
import pl.carp.webapp.model.entity.geo.Journey;
import pl.carp.webapp.repository.geo.JourneyRepository;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Simple integration test with Embedded MongoDB instance
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestRepositoryConfiguration.class)
@DefaultTest
@UsingDataSet(locations = "two-journeys.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
public class JourneyRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private JourneyRepository journeyRepository;

    @Test
    public void shouldNotFindAnyJourneys() {
        String userName = "notExistingUser";

        List<Journey> result = journeyRepository.findByUserName(userName);

        assertEquals(0, result.size());
    }

    @Test
    public void shouldGetTwoEntries() {
        List<Journey> journeys = journeyRepository.findAll();
        assertThat(journeys, hasSize(2));
    }

    @Test
    public void shouldCreateEntity() {
        final String userName = "jake";

        Journey journey = new Journey();
        journey.setUserName(userName);

        journeyRepository.save(journey);

        Journey createdJourney = journeyRepository.findByUserName(userName).get(0);

        assertEquals(userName, createdJourney.getUserName());
    }
}