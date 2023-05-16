package com.example.musiccamp.registration.artist;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArtistRegistrationRequest {
    private String artistName;
    private String email;
    private String password;

}
