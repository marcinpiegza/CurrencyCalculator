package pl.project.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.project.calculator.repository.UserRepository;

import java.util.Optional;

public class AutUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;


    @Autowired
    public AutUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//optional zabezpiecza przed nullem

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
    }
}
