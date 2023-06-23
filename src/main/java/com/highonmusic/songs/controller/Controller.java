package com.highonmusic.songs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class Controller {
    @GetMapping("/")
    public String test(){
        return "Hello from songs microservice.";
    }
}
