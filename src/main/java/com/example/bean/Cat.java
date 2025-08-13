package com.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat {

    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
