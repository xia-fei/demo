package org.xiafei.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author 夏飞
 */
@SpringBootApplication
public class Application {

    public SQLInterceptor sqlInterceptor(){
        return new SQLInterceptor();
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
