package am.cs322.user.presentation.api;



import am.cs322.data.model.UserDTO;
import am.cs322.user.presentation.api.model.CreateUserRequest;

public interface UserController {

    public UserDTO createUser(CreateUserRequest request);

}
