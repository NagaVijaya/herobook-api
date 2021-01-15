package com.gcpublishing.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hero extends Person {
   @Id
   int id;

    /**
     * Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.
     */

        public Hero(){}
        public Hero(int id , String name) {
                this.id = id;
                super.setName(name);
        }

    public int getId() {
        return id;
    }


}
