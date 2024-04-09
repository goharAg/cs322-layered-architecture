package am.cs322.user.presentation.impl;

import am.cs322.user.business.api.UserService;

import am.cs322.user.domain.model.UserDTO;
import am.cs322.user.presentation.api.UserController;
import am.cs322.user.presentation.api.model.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.firstName(), request.lastName());
    }
}
