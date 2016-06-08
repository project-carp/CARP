package pl.carp.backend.controller.autenthication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.carp.webapp.model.entity.ApplicationUser;
import pl.carp.webapp.model.rest.user.RestResponse;
import pl.carp.webapp.repository.ApplicationUserRepository;

import java.util.Date;

/**
 * Created by phar on 2016-06-03.
 */
@RestController
@RequestMapping("/rest/")
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody RestResponse registerUser(@RequestBody ApplicationUser user) {
        log.debug("Attempting to create user by its name '{}'...", user.getUserName());
        RestResponse response = new RestResponse();
        if(applicationUserRepository.findByUserName(user.getUserName()) == null) {
            ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
            user.setCreatedDate(new Date());
            user.setPassword(shaPasswordEncoder.encodePassword(user.getPassword(), String.valueOf(user.getCreatedDate().getTime())));
            applicationUserRepository.save(user);
            log.debug("User created: '{}'...", user.getUserName());
            response.setStatus("ok");
        } else {
            log.debug("Unable to create user. UserName '{}' exists", user.getUserName());
            response.setStatus("userName exists");
        }
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
