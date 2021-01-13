package com.gcpublishing.repository;

import com.gcpublishing.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
     Hero findByName(String name);
}
