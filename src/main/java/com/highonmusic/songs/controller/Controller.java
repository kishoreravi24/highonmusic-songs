package com.highonmusic.songs.controller;

import com.highonmusic.songs.dto.SongDto;
import com.highonmusic.songs.dto.TestDto;
import com.highonmusic.songs.service.SongService;
import com.highonmusic.songs.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
@EnableDiscoveryClient
public class Controller {
    private final TestService testService;
    private final SongService songService;

    @Autowired
    public Controller(TestService testService,SongService songService){
        this.testService = testService;
        this.songService = songService;
    }
    @GetMapping("")
    public String test() {
        return "Hello from songs1 microservice.";
    }

    @GetMapping("/error")
    public String error() {
        return "Error handling endpoint";
    }

    @GetMapping("/getUsers")
    public Iterable<TestDto> getUsers(){
        return  testService.getUsers();
    }

    @GetMapping("/getSongs")
    public String getSongs(){
        List<SongDto> list = (List<SongDto>) songService.getSongs();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        return "Yes, check console";
    }
}
