package it.develhope.Redis1.controllers;

import it.develhope.Redis1.entities.jpa.UserJPA;
import it.develhope.Redis1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Drumstyle92
 * Class that defines a RESTful API endpoint for handling user data
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * UserService dependency to be able to use service methods on users
     */
    @Autowired
    private UserService userService;

    /**
     * @param userjpa Parameter that takes a JPA object in the request body
     * @return        Returns the newly created UserJPA object
     * Method that accepts an HTTP POST request with a body that contains a JSON object
     */
    @PostMapping("")
    public UserJPA create(@RequestBody UserJPA userjpa){
        return userService.create(userjpa);
    }

    /**
     * @return Returns the list of users
     * method that accepts an HTTP GET request and returns a list of all objects
     */
    @GetMapping("")
    public List<UserJPA> readAll(){
        return userService.readAll();
    }

    /**
     * @param id Parameter which takes the id of the selected user
     * @return Returns the selected user
     * method that accepts an HTTP GET request with an id path parameter
     * representing the ID of the user to retrieve and returns the corresponding UserJPA object
     */
    @GetMapping("/{id}")
    public UserJPA readOne(@PathVariable Long id){
        return userService.readOne(id);
    }

    /**
     * @param id      Parameter that takes the id of the user selected for the update
     * @param userjpa Parameter that takes the updated user in the request body
     * @return Return the updated user
     * method that accepts an HTTP PUT request with an id path parameter
     * and a body containing a JSON object representing a UserJPA instance,
     * then updates the corresponding user and returns the updated UserJPA object
     */
    @PutMapping("/{id}")
    public UserJPA update(@PathVariable Long id, @RequestBody UserJPA userjpa){

        return userService.update(id, userjpa);

    }

    /**
     * @param id Parameter which takes the id of the user to delete
     * method that accepts an HTTP DELETE request with an id
     * path parameter representing the ID of the user to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}

