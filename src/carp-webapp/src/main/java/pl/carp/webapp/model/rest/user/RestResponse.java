package pl.carp.webapp.model.rest.user;

import java.io.Serializable;

/**
 * Created by phar on 2016-06-07.
 */
public class RestResponse implements Serializable {

    private String status;

    private String description;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
