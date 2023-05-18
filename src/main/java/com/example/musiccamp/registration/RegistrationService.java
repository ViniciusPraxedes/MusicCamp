package com.example.musiccamp.registration;

import com.example.musiccamp.registration.token.ConfirmationToken;
import com.example.musiccamp.registration.token.ConfirmationTokenService;
import com.example.musiccamp.registration.user.User;
import com.example.musiccamp.registration.user.UserRegistrationRequest;
import com.example.musiccamp.registration.user.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(UserRegistrationRequest request){
       String token = userService.singUpUser(new User(
                request.getUserName(),
                request.getEmail(),
                request.getPassword(),
                request.getAboutYou(),
                request.getProfilePic()
        ));
        return token;
    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("Email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed";
    }

}
