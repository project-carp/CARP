package pl.carp.webapp.model.rest.user.register;


import pl.carp.webapp.model.ApplicationUser;

/**
 * POJO for registration request
 * Created by phar on 2016-06-03.
 */
public class User {

    private ApplicationUser user;

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}
