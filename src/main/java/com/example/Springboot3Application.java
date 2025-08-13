package com.example;

import com.example.bean.Cat;
import com.example.bean.Dog;
import com.example.bean.Pig;
import com.example.bean.Sheep;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;

@Slf4j
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

        ConfigurableEnvironment env = ioc.getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(ConfigurableEnvironment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/doc.html";
        } else {
            contextPath = contextPath + "/doc.html";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("""
                        ----------------------------------------------------------
                        \t应用程序“{}”正在运行中......
                        \t接口文档访问 URL:
                        \t本地: \t\t{}://localhost:{}{}
                        \t外部: \t{}://{}:{}{}
                        \t配置文件: \t{}
                        ----------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles());
    }

}
