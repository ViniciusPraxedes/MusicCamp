package com.example.musiccamp;

import com.example.musiccamp.song.Song;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    private Long Id;
    private String albumName;
    private int numberOfSongs;
    private String albumCoverUrl;
    private boolean isFavorited;
    @OneToMany(targetEntity = Song.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "album-song_fk", referencedColumnName = "album_id")
    private List<Song> songs;
    @OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "album-category_fk", referencedColumnName = "album_id")
    private List<Category> categoriesSongBelongsTo;

}
