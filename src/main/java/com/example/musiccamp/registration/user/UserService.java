package com.example.musiccamp.registration.user;

import com.example.musiccamp.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String singUpUser(User user){
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("Email already in use");
        }

        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);

        return "It works";
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
