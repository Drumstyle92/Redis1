package it.develhope.Redis1.repositories.redis;

import it.develhope.Redis1.entities.redis.UserRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Drumstyle92
 * repository interface that extends the CrudRepository interface
 * provided by Spring Data Redis that handles CRUD operations for
 * UserRedis objects in the Redis database
 */
@Repository
public interface UserRepositoryRedis extends CrudRepository<UserRedis, Long> {

}
