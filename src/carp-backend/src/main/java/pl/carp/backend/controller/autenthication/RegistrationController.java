package pl.carp.backend.controller.autenthication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.web.bind.annotation.*;
import pl.carp.backend.model.entity.ApplicationUser;
import pl.carp.backend.model.enums.RestResponseStatus;
import pl.carp.backend.model.rest.user.RestResponse;
import pl.carp.backend.service.RegistrationService;

/**
 * Created by phar on 2016-06-03.
 */
@RestController
@RequestMapping("/rest/")
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody RestResponse registerUser(@RequestBody ApplicationUser user) {
        log.debug("Attempting to create user by its name '{}'...", user.getUserName());
        RestResponse response = new RestResponse();
        try {
            ApplicationUser applicationUser = registrationService.registerUser(user);
            response.setStatus(RestResponseStatus.SUCCESS);
        } catch (ClientAlreadyExistsException e) {
            response.setStatus(RestResponseStatus.ERROR);
            response.setDescription(e.getLocalizedMessage());
        }

        return response;
    }
}
