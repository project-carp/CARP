package pl.carp.webapp.repository.geo;

import org.springframework.data.geo.Polygon;
import org.springframework.data.repository.CrudRepository;
import pl.carp.webapp.model.entity.geo.Journey;

import java.util.List;

public interface JourneyRepository extends CrudRepository<Journey, String> {

    /**
     * Returns all {@link Journey}s related with given user by its name
     *
     * @param userName must not be {@literal null}.
     * @return list of {@link Journey}s
     */
    List<Journey> findByUserName(String userName);

    /**
     * Returns all {@link Journey}s passing the given {@link Polygon}.
     *
     * @param polygon must not be {@literal null}.
     * @return list of {@link Journey}s
     */
    List<Journey> findByRouteCoordinateListWithin(Polygon polygon);
}