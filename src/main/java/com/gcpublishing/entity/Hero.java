package com.gcpublishing.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Hero {
   @Id
   int id;
   String name;

        public Hero(){

        }
        public Hero(int id , String name) {
                this.id = id;
                this.name = name;
        }
}
