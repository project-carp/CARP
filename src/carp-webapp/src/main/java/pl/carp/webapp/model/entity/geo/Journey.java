package pl.carp.webapp.model.entity.geo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Journey document
 */
@Document(collection = "journeys")
public class Journey {

    @Id
    private String id;

    private String userName;

    private String description;

    /**
     * {@code routeCoordinateList} is a {@link java.util.List} of geographic coordinates stored in GeoJSON format.
     * <p>
     * <pre>
     * <code>
     * {
     *   "type" : "Point",
     *   "coordinates" : [ x, y ]
     * }
     * </code>
     * </pre>
     */
    private List<GeoJsonPoint> routeCoordinateList;

    /* --- Getters & Setters --- */

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GeoJsonPoint> getRouteCoordinateList() {
        return routeCoordinateList;
    }

    public void setRouteCoordinateList(List<GeoJsonPoint> routeCoordinateList) {
        this.routeCoordinateList = routeCoordinateList;
    }
}