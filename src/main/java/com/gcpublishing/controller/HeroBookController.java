package com.gcpublishing.controller;

import com.gcpublishing.entity.Hero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroBookController {

    @GetMapping("/api/heroes")
    public List<Hero> findAllHeroes(){

     return null;
    }
}
