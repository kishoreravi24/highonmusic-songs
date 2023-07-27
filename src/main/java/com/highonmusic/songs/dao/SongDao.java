package com.highonmusic.songs.dao;

import com.highonmusic.songs.dto.SongDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongDao extends MongoRepository<SongDto,String> {
}
