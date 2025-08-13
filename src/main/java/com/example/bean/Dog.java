package com.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {

    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
