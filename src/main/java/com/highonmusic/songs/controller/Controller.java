package com.highonmusic.songs.controller;

import com.highonmusic.songs.dto.TestDto;
import com.highonmusic.songs.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
@EnableDiscoveryClient
public class Controller {
    private final TestService testService;

    @Autowired
    public Controller(TestService testService){
        this.testService = testService;
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
}
