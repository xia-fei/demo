package thread;

/**
 * @author 夏飞
 */
public class ThreadExceptionTest {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                throw new RuntimeException("this is exception");
            }
        };
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        System.out.println("thread start");
    }
}
class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("UncaughtExceptionHandler"+e.getMessage());
    }
}