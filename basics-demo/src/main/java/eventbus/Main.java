package eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * @author 夏飞
 */
public class Main {
    private AsyncEventBus eventBus = new AsyncEventBus(Executors.newSingleThreadExecutor());

    @Before
    public void init(){
        eventBus.register(new EventBodyListener());
    }

    @Test
    public void test1(){
        EventBody eventBody=new EventBody();
        eventBody.setContext("sss");
        eventBody.setId("1");
        eventBus.post(eventBody);
    }

    @Test
    public void test2(){
        EventBody eventBody=new EventBody();
        Cat cat=new Cat();
        cat.setAge(20);
        cat.setName("花花");
        eventBody.setContext(cat);
        eventBody.setId("1");
        eventBus.post(eventBody);
    }

}
class EventBodyListener{
    @Subscribe
    public void handler(EventBody eventBody){
        System.out.println(eventBody);
    }
}
class Cat{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class EventBody{
    private String id;
    private Object context;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }
}
