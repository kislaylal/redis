package com.penndot.redisstorage;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableCaching
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    RedisGreetingRepo repo;
    
    @Cacheable(value = "POC-----------ControllerValue", key = "#name")
    @GetMapping(path = "/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        //return new Greeting(counter.incrementAndGet(),
        //                    String.format(template, name));
    	
    	
    repo.setRedisData(name);	
        return "Hello "+name;
    }
    
    
}
