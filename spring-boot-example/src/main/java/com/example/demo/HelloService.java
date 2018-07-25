package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 夏飞
 */
@Component
public class HelloService {
    @Value("${jdbc.url}")
    String appName;

    public String hello(){
        return appName;
    }
}
