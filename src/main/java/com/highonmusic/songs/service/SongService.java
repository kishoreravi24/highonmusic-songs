package com.highonmusic.songs.service;

import com.highonmusic.songs.dao.SongDao;
import com.highonmusic.songs.dto.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongDao songDao;

    @Autowired
    public SongService(SongDao songDao){
        this.songDao=songDao;
    }

    public Iterable<SongDto> getSongs(){
        return songDao.findAll();
    }

}
