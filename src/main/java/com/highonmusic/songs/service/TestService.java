package com.highonmusic.songs.service;

import com.highonmusic.songs.dao.TestDao;
import com.highonmusic.songs.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final TestDao testDao;

    @Autowired
    public TestService(TestDao testDao){
        this.testDao = testDao;
    }

    public Iterable<TestDto> getUsers(){
        return testDao.findAll();
    }
}
