package pl.carp.webapp.configuration;

import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.carp.webapp.model.entity.ApplicationUser;
import pl.carp.webapp.model.enums.LoginResult;
import pl.carp.webapp.model.rest.user.LoginResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maciej Iskra(mais) on 2016-05-31.
 */
@Component
public class CarpAuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    private Gson jsonSerializer = new Gson();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginResponse result = new LoginResponse();
        result.setResult(LoginResult.AUTHENTICATED);
        if (SecurityContextHolder.getContext().getAuthentication().getDetails() instanceof ApplicationUser) {
            result.setUserData((ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getDetails());
        }

        response.getWriter().print(jsonSerializer.toJson(result));
        response.getWriter().flush();

    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        LoginResponse result = new LoginResponse();
        result.setResult(LoginResult.USER_NOT_FOUND);

        response.getWriter().print(jsonSerializer.toJson(result));
        response.getWriter().flush();

    }
}