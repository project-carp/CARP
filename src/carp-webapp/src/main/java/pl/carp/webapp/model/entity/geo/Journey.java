package pl.carp.webapp.model.entity.geo;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
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

    private List<Point> routeCoordinateList; // consider using GeoJsonPoint class

    /* --- Getters & Setters --- */

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Point> getRouteCoordinateList() {
        return routeCoordinateList;
    }

    public void setRouteCoordinateList(List<Point> routeCoordinateList) {
        this.routeCoordinateList = routeCoordinateList;
    }
}