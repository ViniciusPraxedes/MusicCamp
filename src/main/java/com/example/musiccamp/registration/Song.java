package com.example.musiccamp.registration;

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
public class Song {
    @Id
    private Long Id;
    private String name;
    private String length;
    private String songUrl;
    private String albumCoverUrl;
    private String albumItBelongsTo;
    private Boolean isFavorited;
    private Boolean isItSongOrAlbum;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

}
