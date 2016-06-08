package pl.carp.backend.repository.geo;

import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.carp.backend.model.entity.geo.Journey;

import java.util.List;

public interface JourneyRepository extends MongoRepository<Journey, String> {

    /**
     * Returns all {@link Journey}s related with given user by its name
     *
     * @param userName must not be {@literal null}.
     * @return list of {@link Journey}s
     */
    List<Journey> findByUserName(String userName);

    /**
     * Returns all {@link Journey}s located in the given {@link Polygon}.
     *
     * @param polygon must not be {@literal null}.
     * @return list of {@link Journey}s
     */
    List<Journey> findByRouteCoordinateListWithin(Polygon polygon);
}