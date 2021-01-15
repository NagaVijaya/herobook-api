package com.gcpublishing.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Villain extends Person {
    @Id
    int id;
    private String archRival;

    public Villain() { }

    public Villain(int id, String name) {
        this.id = id;
        super.setName(name);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArchRival() {
        return archRival;
    }
    public void setArchRival(String archRival) {
        this.archRival = archRival;
    }


}
