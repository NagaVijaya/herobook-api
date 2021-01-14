package com.gcpublishing.service;

import com.gcpublishing.entity.Hero;
import com.gcpublishing.entity.Villain;
import com.gcpublishing.repository.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillainService {

    @Autowired
    VillainRepository villainRepository;

    public List<Villain> findAllVillains() {
        return villainRepository.findAll();
    }


    public void addVillain(Villain villain) {
         villainRepository.save(villain);
    }
}
