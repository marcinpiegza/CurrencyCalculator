package pl.project.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.project.calculator.model.User;
import pl.project.calculator.model.UserRole;
import pl.project.calculator.repository.UserRepository;
import pl.project.calculator.repository.UserRoleRepository;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private  final UserRepository userRepository;
    private final UserRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User addUser(User user){
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        return userRepository.save(user);

    }
}
