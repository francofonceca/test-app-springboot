package ui.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestController;
import UserRest.java;

@RestController
// inicializando endpoint /users
@RequestMapping("/users") // http://localhost:8080/users

public class UserController {

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
    public ResponseEntity<UserRest> UserRest( @PathVariable String userId)
    {
        UserRest returnValue = new UserRest();
        returnValue.setEmail("test@test.com");
        returnValue.setFirstName("Franco");
        returnValue.setLastName("Fonceca");

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
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
        UserRest returnValue = new UserRest();
        returnValue.setEmail(UserDetails.getEmail());
        returnValue.setFirstName(UserDetails.getFirstName());
        returnValue.setLastName(UserDetails.getLastName());

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    // declarando metodo PutMapping
    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    // declarando metodo DeleteMapping
    @DeleteMapping
    public String deleteUser()
    {
        return "delete user was called";
    }

}