package pl.project.calculator.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AutUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(userRepository ==null){
            throw new UsernameNotFoundException ();
        }

        return Optional.ofNullable(userRepository.finbByUsername(username)).orElseThrow()
                -> new UsernameNotFoundException()
    }
}
