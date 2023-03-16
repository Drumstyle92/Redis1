package it.develhope.Redis1.repositories.jpa;

import it.develhope.Redis1.entities.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Drumstyle92
 * repository interface that extends the Spring Data JPA JpaRepository interface
 * used for data access and UserJPA entity retrieval
 */
@Repository
public interface UserRepositoryJPA extends JpaRepository<UserJPA, Long> {

}
