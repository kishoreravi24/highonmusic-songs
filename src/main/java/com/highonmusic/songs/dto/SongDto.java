package com.highonmusic.songs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {
    @Id
    private String name;
    private String audio;
    private Tag[] tag;

    private static class Tag{
        private String language;
        private String movie;
    }
}
