package pl.carp.webapp.controller.autenthication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.carp.webapp.model.ApplicationUser;
import pl.carp.webapp.model.rest.user.RestResponse;

/**
 * Created by phar on 2016-06-03.
 */
@RestController
@RequestMapping("/rest/")
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);


    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody RestResponse registerUser(@RequestBody ApplicationUser user) {
        log.debug("Attempting to create user by its name '{}'...", user.getUserName());
        RestResponse response = new RestResponse();
        response.setStatus("ok");
        return response;
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
