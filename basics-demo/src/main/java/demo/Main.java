package demo;

import com.google.common.base.MoreObjects;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 夏飞
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
         URL url=new URL("https://saas.qccr.com/a/a?1=2");
        System.out.printf(url.getHost());
        MoreObjects.firstNonNull(1,2);
    }
}
