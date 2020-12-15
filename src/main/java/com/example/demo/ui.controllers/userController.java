package ui.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestController;
import UserRest.java;
import UpdateUserDetailsRequestModel.java;
import UserServiceImpl.java;
import Autowired.java;

@RestController
// inicializando endpoint /users
@RequestMapping("/users") // http://localhost:8080/users

public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userservice;

    // declarando metodo getMapping
    @GetMapping()
    public String getUsers(
                    @RequestParam(value = "page", defaultValue = "1") int page,
                    @RequestParam(value = "limit", defaultValue = "50") int limit,
                    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
                    )
    {
        return "get user was called with page = " + page + " and limit = " + limit ;
    }

    // declarando metodo getMapping
    @GetMapping(
                path="/{userId}", 
                produces = {
                                MediaType.APPLICATION_XML_VALUE,
                                MediaType.APPLICATION_JSON_VALUE
                            }
                )
    public ResponseEntity<UserRest> getUser( @PathVariable String userId)
    {
        if(true) throw new UserServiceException("A user service exception is thrown");

        if(users.containsKey(userId))
        {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    // declarando metodo PostMapping
    @PostMapping(
                consumes = {
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_JSON_VALUE
                    },
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                }
                )
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
       
        UserRest returnValue = userservice.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    // declarando metodo PutMapping
    @PutMapping(path="/{userId}", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
        },
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }   )
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest userDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails)
        
        return storedUserDetails;
    }

    // declarando metodo DeleteMapping
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id)
    {
        users.remove(id);
        RETURN ResponseEntity.noContent().build();
    }

}