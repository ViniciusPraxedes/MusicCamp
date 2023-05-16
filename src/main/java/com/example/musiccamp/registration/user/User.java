package com.example.musiccamp.registration.user;

import com.example.musiccamp.registration.artist.Artist;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
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
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String aboutYou;
    private String profilePic;
    private List<Album> favoriteAlbums;
    private  List<Song> favoriteSongs;
    private List<Artist>  artistsFollowing = new ArrayList<>();
    private Boolean locked = false;
    private Boolean enabled = false;


    public User(String userName, String email, String password, String aboutYou, String profilePic) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.aboutYou = aboutYou;
        this.profilePic = profilePic;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
