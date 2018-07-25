package com.example.demo;

import com.qccr.framework.insight.component.InsightPropertyPlaceholderConfigurer;
import com.wing.insight.config.ConfigMain;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsightConfigApplication {
    @Bean
    public InsightPropertyPlaceholderConfigurer insightPropertyPlaceholderConfigurer() {
        new ConfigMain("beacon");
        return new InsightPropertyPlaceholderConfigurer();
    }
}