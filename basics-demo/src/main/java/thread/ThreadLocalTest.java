package thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 夏飞
 */
public class ThreadLocalTest {
    @Test
    public void test2() throws InterruptedException {
//        final InheritableThreadLocal<String> threadLocal=new InheritableThreadLocal<>();
        final TransmittableThreadLocal<String> threadLocal=new TransmittableThreadLocal<>();
        threadLocal.set("one");
        //模拟Servlet,或者dubbo业务线程
        final ExecutorService executorService1=Executors.newFixedThreadPool(1);
        //模拟业务线程
        final ExecutorService executorService2=Executors.newFixedThreadPool(1);
        //先让主线程初始化线程
        executorService1.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        executorService2.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        //正式开始,模拟某一个业务代码
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
                threadLocal.set("two");
                //子线程异步执行
                executorService2.execute(TtlRunnable.get(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(threadLocal.get());
                    }
                }));
            }
        });
        executorService1.awaitTermination(1,TimeUnit.SECONDS);


    }

    @Test
    public void test1(){
        final InheritableThreadLocal<String> inheritableThreadLocal=new InheritableThreadLocal<>();
        inheritableThreadLocal.set("1");
        System.out.println("1 "+Thread.currentThread().getName()+inheritableThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2 "+Thread.currentThread().getName()+inheritableThreadLocal.get());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("3 "+Thread.currentThread().getName()+inheritableThreadLocal.get());
                    }
                }).start();
            }
        }).start();
    }
}
