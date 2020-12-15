package userservice;

import UserRest;
import UserDetailsRequestModel;


public interface UserService {
    UserRest createUser(UserDetailsRquestModel userDetails);
}