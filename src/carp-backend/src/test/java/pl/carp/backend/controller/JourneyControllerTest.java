package pl.carp.backend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.carp.backend.configuration.annotation.DefaultWebTest;

import static org.junit.Assert.assertEquals;

/**
 * Journey REST Controller tests
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DefaultWebTest
public class JourneyControllerTest {

    @Test
    public void shouldDoNothing() {
        assertEquals(true, true);
    }
}