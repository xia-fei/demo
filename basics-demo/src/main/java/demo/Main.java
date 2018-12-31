package demo;

import com.google.common.base.MoreObjects;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 夏飞
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
         URL url=new URL("https://saas.qccr.com/a/a?1=2");
        System.out.printf(url.getHost());
        MoreObjects.firstNonNull(1,2);
    }



    @Test
    public void test1(){
        float f=173.8125F;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
        System.out.println(0.2+0.4);
    }


}
