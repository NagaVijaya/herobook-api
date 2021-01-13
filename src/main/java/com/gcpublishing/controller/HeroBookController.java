package com.gcpublishing.controller;

import com.gcpublishing.entity.Hero;
import com.gcpublishing.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroBookController {

    @Autowired
    HeroService heroService;

    @GetMapping("/api/heroes")
    public List<Hero> findAllHeroes(){

     return heroService.findAll();
    }


    @GetMapping("/api/heroes/name/{name}")
    public ResponseEntity<Hero> findHeroByName(@PathVariable String name) {

        Hero hero = heroService.findByName(name);
        ResponseEntity responseEntity = new ResponseEntity(hero, HttpStatus.OK);
        if (hero == null) {
            responseEntity = new ResponseEntity(hero, HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }
}
