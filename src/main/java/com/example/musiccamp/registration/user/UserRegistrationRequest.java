package com.example.musiccamp.registration.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRegistrationRequest {
    private String userName;
    private String email;
    private String password;
    private String aboutYou;
    private String profilePic;

}
