package com.gcpublishing.service;

import com.gcpublishing.entity.Villain;
import com.gcpublishing.repository.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VillainService {

    @Autowired
    VillainRepository villainRepository;

    public List<Villain> findAllVillains() {
        return villainRepository.findAll();
    }
}
