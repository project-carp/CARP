package pl.carp.webapp.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.carp.webapp.model.ApplicationUser;
import pl.carp.webapp.repository.ApplicationUserComplexRepository;
import pl.carp.webapp.repository.ApplicationUserRepository;

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
}