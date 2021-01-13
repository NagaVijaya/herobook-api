package com.gcpublishing.service;

import com.gcpublishing.entity.Hero;
import com.gcpublishing.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public void addHero(Hero hero) {
        heroRepository.save(hero);
    }

    public Hero findByName(String name) {
        return heroRepository.findByName(name);
    }
}
