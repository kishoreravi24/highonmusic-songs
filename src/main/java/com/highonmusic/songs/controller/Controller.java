package com.highonmusic.songs.controller;

import com.highonmusic.songs.dto.SongDto;
import com.highonmusic.songs.dto.TestDto;
import com.highonmusic.songs.service.SongService;
import com.highonmusic.songs.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/songs")
@EnableDiscoveryClient
public class Controller {
    private final TestService testService;
    private final SongService songService;

    private final RestTemplate restTemplate;
    private String token="";

    @Autowired
    public Controller(TestService testService, SongService songService,RestTemplate restTemplate){
        this.testService = testService;
        this.songService = songService;
        this.restTemplate = restTemplate;
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
    public List<SongDto> getSongs(){
        String usersServiceUrl = "http://localhost:5000/users/passToken";
        ResponseEntity<String> response = restTemplate.getForEntity(usersServiceUrl, String.class);
        token = response.getBody();
        List<SongDto> list = new ArrayList<>();
        if(token.length()>5){
            list = (List<SongDto>) songService.getSongs();
        }
        return list;
    }
}
