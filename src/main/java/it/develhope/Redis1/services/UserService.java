package it.develhope.Redis1.services;

import it.develhope.Redis1.entities.jpa.UserJPA;
import it.develhope.Redis1.entities.redis.UserRedis;
import it.develhope.Redis1.repositories.jpa.UserRepositoryJPA;
import it.develhope.Redis1.repositories.redis.UserRepositoryRedis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Drumstyle92
 * Service class that contains the business logic of the CRUD on user data
 */
@Service
public class UserService {

    /**
     * UserRepositoryJPA interface dependency to handle user data
     * persistence operations in a relational database
     */
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    /**
     * Dependency of the UserRepositoryRedis interface which gives
     * us the possibility to interact with an open source database in memory,
     * used as a cache and for storing data
     */
    @Autowired
    private UserRepositoryRedis userRepositoryRedis;

    /**
     * @param userjpa Parameter that takes a UserJPA object
     * @return Returns a UserRedis object
     * method that takes a UserJPA object and converts it to a UserRedis object
     */
    public UserRedis convertData(UserJPA userjpa){

        UserRedis userRedis = new UserRedis();

        BeanUtils.copyProperties(userjpa, userRedis);

        return userRedis;

    }

    /**
     * @param userJPA Parameter that UserRedis takes
     * @return Returns a UserJPA object
     * method that takes a UserRedis object and converts it to a UserJPA object
     */
    public UserJPA convertData(UserRedis userJPA){

        UserJPA userRedis = new UserJPA();

        BeanUtils.copyProperties(userJPA, userRedis);

        return userRedis;

    }


    /**
     * @param userjpa Parameter that takes the constructed JPA object
     * @return Returns the created object
     * Post method that creates a new UserJPA object and saves it in the JPA repository
     */
    public UserJPA create(UserJPA userjpa) {

        if(userjpa == null){return null;}

        userjpa.setId(null);

        return userRepositoryJPA.save(userjpa);

    }

    /**
     * @return Returns the list of users
     * get method which returns a list of all UserJPA objects stored in the JPA repository
     */
    public List<UserJPA> readAll() {
        return userRepositoryJPA.findAll();
    }

    /**
     * @param id Parameter which takes the id of the selected user
     * @return Return the selected user to the Radis cache or from the JPA repository
     * get method which takes an id parameter and retrieves the corresponding
     * UserJPA object from the Redis cache or JPA repository if it is not found in the cache
     */
    public UserJPA readOne(Long id) {

        UserJPA userFromCache = userRepositoryRedis.findById(id)
                .map(this::convertData)

                .orElse(null);

        if(userFromCache != null){

            return userFromCache;

        }

        UserJPA userFromDB = userRepositoryJPA.findById(id)
                .orElse(null);

        if(userFromDB != null){

            userRepositoryRedis.save(convertData(userFromDB));

        }

        return userFromDB;

    }

    /**
     * @param id      Parameter that takes the object id of the user to be modified
     * @param userjpa Parameter that takes the modified object
     * @return Return the updated JPA object
     * Put method which takes an id parameter and a UserJPA object,
     * updates the user details in the JPA repository and also updates
     * the corresponding UserRedis object in the cache if it exists
     */
    public UserJPA update(Long id, UserJPA userjpa) {

        if(userjpa == null) return null;

        userjpa.setId(id);

        Optional<UserJPA> optionalUser = userRepositoryJPA.findById(id);

        if (optionalUser.isEmpty()) {

            throw new IllegalArgumentException("User with id " + id + " not found");

        }

        UserJPA newUser = userRepositoryJPA.save(userjpa);

        Optional<UserRedis> optionalUserRedis = userRepositoryRedis.findById(id);

        if(optionalUserRedis.isPresent()) {

            userRepositoryRedis.save(convertData(newUser));

        }

        return userjpa;

    }

    /**
     * @param id Parameter that takes the object id of the user to be deleted
     * Delete method which takes an id parameter and deletes
     * the corresponding UserJPA object from the JPA repository
     * and the corresponding UserRedis object from the cache
     */
    public void delete(Long id) {

        userRepositoryJPA.deleteById(id);

        userRepositoryRedis.deleteById(id);

    }

}

