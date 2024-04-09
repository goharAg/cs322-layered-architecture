package am.cs322.user.business.api;

import am.cs322.data.model.UserDTO;

public interface UserService {

    public UserDTO createUser(String firstName, String lastName);

}