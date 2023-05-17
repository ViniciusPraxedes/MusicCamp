package com.example.musiccamp.song;

import com.example.musiccamp.Category;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SongRequest {
    private String songName;
    private String albumCoverFileName;
    private List<Category> categoriesSongBelongsTo;
}
