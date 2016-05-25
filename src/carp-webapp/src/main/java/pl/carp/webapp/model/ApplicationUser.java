package pl.carp.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * CARP Application User document
 */
@Document(collection = "users")
public class ApplicationUser {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    private String password;

    /* ----- Getters & Setters ----- */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}