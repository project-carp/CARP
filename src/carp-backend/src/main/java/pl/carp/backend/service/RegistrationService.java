package pl.carp.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.stereotype.Service;
import pl.carp.backend.model.entity.ApplicationUser;
import pl.carp.backend.repository.ApplicationUserRepository;

import java.util.Date;

/**
 * Created by grze on 2016-06-08.
 */
@Service
public class RegistrationService {

    private static final Logger log = LoggerFactory.getLogger(RegistrationService.class);

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUser registerUser(ApplicationUser user) {
        if(applicationUserRepository.findByUserName(user.getUserName()) == null) {
            ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
            user.setCreatedDate(new Date());
            user.setPassword(shaPasswordEncoder.encodePassword(user.getPassword(), String.valueOf(user.getCreatedDate().getTime())));
            applicationUserRepository.save(user);
            log.debug("User '{}' created", user.getUserName());
            return user;
        } else {
            log.debug("Unable to create user. UserName '{}' exists", user.getUserName());
            throw new ClientAlreadyExistsException("Username exists");
        }
    }
}
