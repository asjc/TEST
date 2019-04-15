package com.example.vue.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "politicsstatus")
public class PoliticsStatus {
    public PoliticsStatus(){

    }
    public PoliticsStatus(String name){
        this.name=name;
    }
    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
