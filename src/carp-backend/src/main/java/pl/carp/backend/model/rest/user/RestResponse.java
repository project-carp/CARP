package pl.carp.backend.model.rest.user;

import pl.carp.backend.model.enums.RestResponseStatus;

import java.io.Serializable;

/**
 * Created by phar on 2016-06-07.
 */
public class RestResponse implements Serializable {

    private RestResponseStatus status;

    private String description;

    public RestResponseStatus getStatus() {
        return status;
    }

    public void setStatus(RestResponseStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
