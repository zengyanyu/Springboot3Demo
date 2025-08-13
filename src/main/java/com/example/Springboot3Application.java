package com.example;

import com.example.bean.Cat;
import com.example.bean.Dog;
import com.example.bean.Pig;
import com.example.bean.Sheep;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class Springboot3Application {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Springboot3Application.class, args);
        // 1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println("name = " + name);
//        }
        String[] cats = ioc.getBeanNamesForType(Cat.class);
        for (String s : cats) {
            System.out.println("cats = " + s);
        }
        String[] dogs = ioc.getBeanNamesForType(Dog.class);
        for (String s : dogs) {
            System.out.println("dogs = " + s);
        }
        Pig pig = ioc.getBean(Pig.class);
        System.out.println("猪 = " + pig);
        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println("羊 = " + sheep);
    }

}
