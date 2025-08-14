package com.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Redis控制器", description = "Redis控制器描述")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 增加
     *
     * @return
     */
    @GetMapping("/incr")
    @Operation(summary = "redis方法_增加", description = "redis方法_增加描述")
    public String incr() {
        // 给haha的可以数量+1
        Long haha = redisTemplate.opsForValue().increment("haha");
        return "返回最新的数量： haha = " + haha;
    }

}
