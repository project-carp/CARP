package pl.carp.webapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.carp.backend.model.entity.ApplicationUser;
import pl.carp.backend.repository.ApplicationUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides details of internal users defined in CARP
 * Created by Maciej Iskra(mais) on 2016-05-31.
 */

@Component
class CarpAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
        ApplicationUser user = applicationUserRepository.findByUserName((String) authentication.getPrincipal());
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' has not been found", authentication.getPrincipal()));
        }

        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
        if(!shaPasswordEncoder.isPasswordValid(user.getPassword(), (String)authentication.getCredentials(), String.valueOf(user.getCreatedDate().getTime()))) {
            throw new BadCredentialsException(String.format("Password for user '%s' is not valid", authentication.getPrincipal()));
        }
        List<GrantedAuthority> roles = user.getRoles() == null ? new ArrayList<>()
                : user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), roles);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

