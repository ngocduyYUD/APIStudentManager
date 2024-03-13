package com.webapi.StudentsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectTest implements CommandLineRunner {
    @Autowired
    private RedisTemplate template;
    @Override
    public void run(String... args) throws Exception {
        template.opsForValue().set("test","hello world");

        System.out.println("Value of key test: "+template.opsForValue().get("test"));
    }
}
