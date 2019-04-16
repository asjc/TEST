package com.entity;

//import javax.persistence.*;

//@Entity(name = "t_book")
public class Book {
    private int id;
    private String name;
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "book_name",nullable = false)
//    private String name;
//    private String author;
//    private Float price;
//    @Transient
//    private String description;


}
