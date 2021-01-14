package com.gcpublishing.controller;

import com.gcpublishing.entity.Villain;
import com.gcpublishing.service.VillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VillainBookController {

    @Autowired
    VillainService villainService;

    @GetMapping("/api/villains")
    public List<Villain> findAllVillains(){
      return villainService.findAllVillains();
    }
}
