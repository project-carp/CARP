package pl.carp.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.carp.backend.model.entity.ApplicationUser;

/**
 * Very simple MongoDB CRUD repository featured by Spring Data
 */
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {

    ApplicationUser findByUserName(String userName);
}