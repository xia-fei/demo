package demo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import demo.model.StoreCategoryRO;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author 夏飞
 */
public class Main {


    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://saas.qccr.com/a/a?1=2");
        System.out.printf(url.getHost());
        MoreObjects.firstNonNull(1, 2);
    }


    @Test
    public void test3() throws MalformedURLException, ClassNotFoundException {
        String className = "demo.model.LoaderTest";
        URL path = Main.class.getResource("/LoaderTest.class");

    }

    @Test
    public void test2() throws IOException {
        String jsonString = "[{\"photoType\":\"XINGXIANG_PHOTO\",\"photoUrls\":[{\"value\":\"发发发\",\"url\":\"http://s00.qccr.com/qccr/g01/workorder/2018/12/9fa66ca56784984d.jpg\"}],\"photoTypeName\":\"形象照片\"},{\"photoType\":\"HUANJING_PHOTO\",\"photoUrls\":[{\"value\":\"绅士手\",\"url\":\"http://s00.qccr.com/qccr/g01/workorder/2018/12/f0046dc4af30c351.jpg\"}],\"photoTypeName\":\"环境照片\"},{\"photoType\":\"SHESHI_PHOTO\",\"photoUrls\":[{\"value\":\"方法\",\"url\":\"http://s00.qccr.com/qccr/g01/workorder/2018/12/15a758fd2700a004.jpg\"}],\"photoTypeName\":\"设施照片\"},{\"photoType\":\"CHEJIAN_PHOTO\",\"photoUrls\":[{\"value\":\"北包包\",\"url\":\"http://s00.qccr.com/qccr/g01/workorder/2018/12/13a14aecf174ec41.jpg\"}],\"photoTypeName\":\"车间照片\"},{\"photoType\":\"TUANDUI_PHOTO\",\"photoUrls\":[{\"value\":\"啊啊\",\"url\":\"http://s00.qccr.com/qccr/g01/workorder/2018/12/bb4a3b47a166ef8a.jpg\"}],\"photoTypeName\":\"团队照片\"},{\"photoType\":\"YINGYEZHIZHAO_PHOTO\",\"photoUrls\":[{\"value\":\"营业执照\",\"url\":\"http://s00.qccr.com/qccr/g01/workorder/2018/12/f2f6288c0f889a39.jpg\"}],\"photoTypeName\":\"营业执照照片\"}]";
        System.out.println(jsonString);
        ObjectMapper objectMapper = new ObjectMapper();

        Object o = objectMapper.readValue(jsonString, new MyTypeReference());
        System.out.println(JSON.toJSONString(o));
    }


    @Test
    public void test1() {
        float f = 173.8125F;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
        System.out.println(0.2 + 0.4);
    }


    class MyTypeReference extends TypeReference<List<StoreCategoryRO>> {

    }
}
