package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.exception.UserAlreadyExistException;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public User validateAndRegisterNewUser(UserDto user) throws UserAlreadyExistException {
        if (alreadyExists(user.getEmail())) {
            throw new UserAlreadyExistException();
        } else {
            return registerNewUser(user);
        }
    }

    private User registerNewUser(UserDto userDto) {
        Role role = roleRepository.findByName("ROLE_USER");
        User user = User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .enabled(true)
                .roles(List.of(role))
                .build();

        return userRepository.save(user);

    }

    private boolean alreadyExists(String email) {
        return userRepository.findByEmail(email) != null;
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
