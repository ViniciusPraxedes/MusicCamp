package com.example.musiccamp.registration.artist;

import com.example.musiccamp.registration.Song;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Artist implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String artistName;
    private String email;
    private String aboutYou;
    private String profilePicUrl;
    private List<Album>Albums;
    @Transient
    private List<Song> songs;


    public Artist(String artistName, String email, String aboutYou, String profilePicUrl) {
        this.artistName = artistName;
        this.email = email;
        this.aboutYou = aboutYou;
        this.profilePicUrl = profilePicUrl;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
