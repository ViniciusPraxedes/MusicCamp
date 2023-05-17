package com.example.musiccamp.registration;

import com.example.musiccamp.registration.user.User;
import com.example.musiccamp.registration.user.UserRegistrationRequest;
import com.example.musiccamp.registration.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(UserRegistrationRequest request){
        String Token = userService.singUpUser(new User(
                request.getUserName(),
                request.getEmail(),
                request.getPassword(),
                request.getAboutYou(),
                request.getProfilePic()
        ));

        return Token;
    }
}
