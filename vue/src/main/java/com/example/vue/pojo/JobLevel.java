package com.example.vue.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "joblevel")
public class JobLevel {
    public JobLevel(){

    }
    public JobLevel(String name){
        this.name=name;
    }
    @Id
    private int id;
    private String name;
    private String titleLevel;
    private Timestamp create_Date;
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

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public Timestamp getCreateDate() {
        return create_Date;
    }

    public void setCreateDate(Timestamp createDate) {
        this.create_Date = createDate;
    }
}
