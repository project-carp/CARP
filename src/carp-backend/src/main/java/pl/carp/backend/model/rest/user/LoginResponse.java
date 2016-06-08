package pl.carp.backend.model.rest.user;

import pl.carp.backend.model.entity.ApplicationUser;
import pl.carp.backend.model.enums.LoginResult;

import java.io.Serializable;

/**
 * Contains details of authentication process
 * Created by Maciej Iskra(mais) on 2016-05-31.
 */
public class LoginResponse implements Serializable{
    private LoginResult result;
    private ApplicationUser userData;

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }

    public ApplicationUser getUserData() {
        return userData;
    }

    public void setUserData(ApplicationUser userData) {
        this.userData = userData;
    }
}
