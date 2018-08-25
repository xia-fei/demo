package org.xiafei.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author 夏飞
 */
@SpringBootApplication
public class Application {


    @Bean
    public SQLInterceptor sqlInterceptor(){
        return new SQLInterceptor();
    }

    @Bean
    public String stringBean(){
        return "hello,word";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(Application.class, args);

    }
}
