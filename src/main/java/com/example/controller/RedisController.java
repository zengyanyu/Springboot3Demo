package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 增加
     *
     * @return
     */
    @GetMapping("/incr")
    public String incr() {
        // 给hha的可以数量+1
        Long haha = redisTemplate.opsForValue().increment("haha");
        return "返回最新的数量： haha = " + haha;
    }
}
