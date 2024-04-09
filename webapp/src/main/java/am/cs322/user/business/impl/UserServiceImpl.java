package am.cs322.user.business.impl;

import am.cs322.data.UserRepository;
import am.cs322.data.model.User;
import am.cs322.data.model.UserDTO;
import am.cs322.user.business.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO createUser(String firstName, String lastName) {
        User createdUser = userRepository.save(new User(firstName, lastName));
        return new UserDTO(createdUser.getFirstName() + " " + createdUser.getLastName());
    }

}