package org.xiafei.spring.boot;

import com.wing.core.mock.MockData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 夏飞
 */
@RestController
public class Controller {

    @RequestMapping("/get")
    public String get() {
        return "hello,spring-boot";
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello,spring-boot";
    }

    @RequestMapping(value = "/loadClass")
    public Object classLoader(@RequestParam(required = false, name = "class") String className) throws MalformedURLException, ClassNotFoundException {
        String url = "jar:https://xiafei-web.oss-cn-hangzhou.aliyuncs.com/file-server/1546178048080.jar!/";
        URL jarUrl = new URL(url);
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jarUrl});
        return new MockData().mock(urlClassLoader.loadClass(className == null ? "com.qccr.shprod.facade.entity.chartindex.chart.TurnoverBasicFactsRO" : className));
    }


}
