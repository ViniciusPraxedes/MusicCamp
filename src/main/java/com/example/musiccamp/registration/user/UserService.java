package com.example.musiccamp.registration.user;

import com.example.musiccamp.registration.email.EmailSender;
import com.example.musiccamp.registration.token.ConfirmationToken;
import com.example.musiccamp.registration.token.ConfirmationTokenService;
import com.example.musiccamp.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String singUpUser(User user){

        String token;
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
           token = "Email already in use";
        }else {
            String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encodedPassword);

            token = UUID.randomUUID().toString();
            ConfirmationToken confirmationToken = new ConfirmationToken(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    user
            );
            confirmationTokenService.saveConfirmationToken(confirmationToken);

            String email = user.getEmail();
            String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;


            emailSender.sendEmail(user.getEmail(),"Confirm your email","Thank you for testing Music camp, confirm your account by clicking on the link: "+link);


            userRepository.save(user);

        }

        return token;
    }

    public void enableUser(String email) {
        userRepository.enableUser(email);
    }
    public void changeProfilePic(String email, String profilePicUrl){
        userRepository.changeProfilePic(email, profilePicUrl);
    }



}
