package com.example.musiccamp.registration.artist;

import com.example.musiccamp.Album;
import com.example.musiccamp.song.Song;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
    @Column(name = "artist_id")
    private Long id;
    private String artistName;
    private String password;
    private String email;
    private String aboutYou;
    private String profilePicUrl;
    @OneToMany(targetEntity = Album.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist-album_fk", referencedColumnName = "artist_id")
    private List<Album>Albums;
    @OneToMany(targetEntity = Song.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist-song_fk", referencedColumnName = "artist_id")
    private List<Song> songs;


    public Artist(String artistName, String email, String aboutYou, String profilePicUrl, String password) {
        this.password = password;
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
