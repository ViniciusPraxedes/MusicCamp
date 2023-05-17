package com.example.musiccamp.song;

import com.example.musiccamp.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "song_id")
    private Long Id;
    private String name;
    private String length;
    private String songFileName;
    private String albumCoverFileName;
    private String albumItBelongsTo;
    private Boolean isFavorited;
    private Boolean isItASong = true;
    @OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "song-category_fk", referencedColumnName = "song_id")
    private List<Category> categoriesSongBelongsTo;

    public Song(String name, String songFileName, String albumCoverFileName, String albumItBelongsTo, List<Category> categoriesSongBelongsTo) {
        this.name = name;
        this.songFileName = songFileName;
        this.albumCoverFileName = albumCoverFileName;
        this.albumItBelongsTo = albumItBelongsTo;
        this.categoriesSongBelongsTo = categoriesSongBelongsTo;
    }
}
