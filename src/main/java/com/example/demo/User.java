package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    protected User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
