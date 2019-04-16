package com.entity;

import com.dao.ValidationGroup1;
import com.dao.ValidationGroup2;

import javax.validation.constraints.*;

public class User {
    private int id;
    @Size(min = 5,max = 10,message = "{user.name.size}",groups = ValidationGroup1.class)
    private String name;
    @NotNull(message = "{user.address.notnull}",groups = ValidationGroup2.class)
    private String address;
    @DecimalMin(value = "1",message = "{user.age.size}")
    @DecimalMax(value = "200",message = "{user.age.size}")
    private int age;
    @Email(message = "{user.email.pattern}")
    @NotNull(message = "{user.email.notnull}",groups = {ValidationGroup1.class,ValidationGroup2.class})
    private String email;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
