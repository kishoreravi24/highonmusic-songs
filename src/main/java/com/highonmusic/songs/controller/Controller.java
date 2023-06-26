package com.highonmusic.songs.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
@EnableDiscoveryClient
public class Controller {
    @GetMapping("")
    public String test(){
        return "Hello from songs microservice.";
    }

    @GetMapping("/error")
    public String error() {
        return "Error handling endpoint";
    }
}
