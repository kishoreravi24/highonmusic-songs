package com.highonmusic.songs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "songs")
public class SongDto {
    @Id
    private String name;
    private String audio;
    private Tag[] tag;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Tag{
        private String language;
        private String movie;
    }
}
