package am.cs322.user.business.api;


import am.cs322.user.domain.model.UserDTO;

public interface UserService {

    public UserDTO createUser(String firstName, String lastName);

}