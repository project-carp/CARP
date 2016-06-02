package pl.carp.webapp.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.carp.webapp.model.ApplicationUser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides details of internal users defined in CARP
 * Created by Maciej Iskra(mais) on 2016-05-31.
 */

@Component
class CarpAuthenticationProvider implements AuthenticationProvider {

    @Override
    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
        ApplicationUser user = new ApplicationUser();//TODO add mongo DB
        user.setUserName((String) authentication.getPrincipal());
        user.setPassword((String) authentication.getCredentials());
        user.setRoles(Arrays.asList("ROLE_USER"));
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' has not been found", authentication.getPrincipal()));
        }
        if (user.getPassword().equals(authentication.getCredentials()) == false) {
            throw new BadCredentialsException(String.format("Password for user '%s' is not valid", authentication.getPrincipal()));
        }
        List<GrantedAuthority> roles = user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), roles);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

