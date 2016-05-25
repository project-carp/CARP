package pl.carp.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.carp.webapp.model.ApplicationUser;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Simple Repository bean using implicit MongoTemplate bean
 */
@Repository
public class ApplicationUserComplexRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public ApplicationUser findByUserName(String userName) {
        return mongoTemplate.findOne(query(where("userName").is(userName)), ApplicationUser.class);
    }

    public ApplicationUser save(ApplicationUser user) {
        mongoTemplate.save(user);

        return mongoTemplate.findOne(query(where("userName").is(user.getUserName())), ApplicationUser.class);
    }
}