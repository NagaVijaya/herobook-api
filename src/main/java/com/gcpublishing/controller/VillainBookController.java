package com.gcpublishing.controller;

import com.gcpublishing.entity.Villain;
import com.gcpublishing.service.VillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VillainBookController {

    @Autowired
    VillainService villainService;

    @GetMapping("/api/villains")
    public List<Villain> findAllVillains() {
        return villainService.findAllVillains();
    }

    @GetMapping("/api/villains/name/{name}")
    public ResponseEntity findVillainByName(@PathVariable String name) {

        ResponseEntity responseEntity;
        Villain villain = villainService.findByName(name);
        if (villain == null)
            responseEntity = new ResponseEntity("Villain does not exist", HttpStatus.NOT_FOUND);
        else
            responseEntity = new ResponseEntity(villain, HttpStatus.OK);

        return responseEntity;
    }

}
