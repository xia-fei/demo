package org.xiafei.spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夏飞
 */
@RestController
public class Controller {

    @RequestMapping("/get")
    public String get(){
        return "hello,spring-boot";
    }
}
