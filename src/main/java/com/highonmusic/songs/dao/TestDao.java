package com.highonmusic.songs.dao;

import com.highonmusic.songs.dto.TestDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestDao extends MongoRepository<TestDto,String> {
}
