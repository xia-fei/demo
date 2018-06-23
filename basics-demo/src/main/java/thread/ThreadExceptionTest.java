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
        thread.setUncaughtExceptionHandler(null);
        thread.start();

        System.out.println("thread start");
    }
}
