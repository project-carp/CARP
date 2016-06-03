package pl.carp.webapp.controller.geo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carp.webapp.model.entity.geo.Journey;
import pl.carp.webapp.repository.geo.JourneyRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/journeys/")
public class JourneyController {
    private static final Logger log = LoggerFactory.getLogger(JourneyController.class);

    @Autowired
    private JourneyRepository journeyRepository;

    @RequestMapping("/list/{username}")
    public List<Journey> getJourneysByUserName(@PathVariable("username") String userName) {
        log.debug("Attempting to get journeys of the user '{}'...", userName);

        if (StringUtils.isBlank(userName)) {
            log.debug("User name parameter is blank - returning an empty list...");
            return Collections.emptyList();
        }

        List<Journey> result = journeyRepository.findByUserName(userName);
        log.info("Got '{}' journey related with user '{}'.", result.size(), userName);

        return result;
    }
}