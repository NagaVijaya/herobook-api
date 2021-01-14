package com.gcpublishing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VillainBookController {

    @GetMapping("/api/villains")
    public void findAllVillains(){

    }
}
