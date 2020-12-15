package userservice.impl;

import UserRest;
import UserDetailsRequestModel;
import UserService;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import shared.Utils;
import Service;
import Autowired;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl( Utils utils)
    {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(UserDetails.getEmail());
        returnValue.setFirstName(UserDetails.getFirstName());
        returnValue.setLastName(UserDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId)
        
        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}