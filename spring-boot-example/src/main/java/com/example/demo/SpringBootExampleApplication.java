package com.example.demo;

import com.qccr.framework.insight.component.InsightPropertyPlaceholderConfigurer;
import com.wing.insight.config.ConfigMain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(InsightConfigApplication.class).child(SpringBootExampleApplication.class).run(args);
    }


}
