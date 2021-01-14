package com.gcpublishing.repository;


import com.gcpublishing.entity.Villain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainRepository extends JpaRepository<Villain,Integer> {
   public Villain findByName(String name);
}
