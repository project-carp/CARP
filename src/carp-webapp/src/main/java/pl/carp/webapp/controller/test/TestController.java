package pl.carp.webapp.controller.test;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.carp.webapp.model.entity.ApplicationUser;
import pl.carp.webapp.model.entity.geo.Journey;
import pl.carp.webapp.repository.ApplicationUserComplexRepository;
import pl.carp.webapp.repository.ApplicationUserRepository;
import pl.carp.webapp.repository.geo.JourneyRepository;

import java.util.Arrays;
import java.util.List;

/**
 * Simple Testing Controller
 */
@RestController
@RequestMapping("/test/")
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private ApplicationUserComplexRepository userComplexRepository;

    @Autowired
    private JourneyRepository journeyRepository;

    @RequestMapping("/user")
    public ApplicationUser getUser(@RequestParam(value = "username", defaultValue = "testUser") String userName) {
        log.debug("Attempting to get user by its name '{}'...", userName);
        ApplicationUser user = userRepository.findByUserName(userName);

        return handleUserResult(user);
    }

    @RequestMapping("/user2/{username}")
    public ApplicationUser getUser2(@PathVariable("username") String userName) {
        log.debug("Attempting to get user by its name '{}'...", userName);
        ApplicationUser user = userComplexRepository.findByUserName(userName);

        return handleUserResult(user);
    }

    @RequestMapping("/users")
    public List<ApplicationUser> getUsers() {
        log.debug("Attempting to get user by its name '{}'...");
        List<ApplicationUser> userList = userRepository.findAll();
        log.debug("Got '{}' users.", userList.size());

        return userList;
    }

    protected ApplicationUser handleUserResult(ApplicationUser user) {
        if (user != null) {
            log.debug("Got user with id '{}'.", user.getId());
            return user;
        } else {
            log.debug("Unfortunately there is not a user with given name...");
            return null;
        }
    }

    @RequestMapping("/journeys/save")
    public String saveJourneys() {
        Journey journey = new Journey();
        journey.setUserName("user");
        journey.setDescription("description");
        journey.setRouteCoordinateList(
                Arrays.asList(new Point(33, 44),
                        new Point(44, 55),
                        new Point(55, 66),
                        new Point(66, 77),
                        new Point(77, 88),
                        new Point(88, 99)));
        try {
            journeyRepository.save(journey);
            return "ok";
        } catch (Exception e) {
            log.error("Error!", e);
            return "not_ok";
        }
    }

    @RequestMapping("/journeys/find")
    public List<Journey> getJourneys() {

        return journeyRepository.findAll();
    }

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerSomething(@RequestBody ApplicationUser user) {
        if (StringUtils.isBlank(user.getUserName()) == false) {
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not-ok", HttpStatus.FORBIDDEN);
        }
    }
}