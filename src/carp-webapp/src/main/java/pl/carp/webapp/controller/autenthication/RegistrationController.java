package pl.carp.webapp.controller.autenthication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.carp.webapp.model.ApplicationUser;
import pl.carp.webapp.model.rest.user.register.User;

/**
 * Created by phar on 2016-06-03.
 */
@RestController
@RequestMapping("/rest/")
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody User user) {
        log.debug("Attempting to create user by its name '{}'...", user.getUserName());
        return new User("aaa", "bb");
        /*ApplicationUser user = userRepository.findByUserName(userName);

        return handleUserResult(user);*/
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
