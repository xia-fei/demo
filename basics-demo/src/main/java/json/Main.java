package json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author 夏飞
 */
public class Main {
    @Test
    public void test1()  {
        System.out.println(JSON.toJSONString(null));
    }
}
