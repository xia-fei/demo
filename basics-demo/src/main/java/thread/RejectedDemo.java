package thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 处理更次数多
 * 减少数据库访问次数线程池
 * @author 夏飞
 */
public class RejectedDemo {

    public static void main(String[] args) {
        new RejectedDemo().start();
    }

    public void start() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1), new MaxRejectedExecutionHandler());
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("当前访问人数:" + i);
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.execute(new TaskRunnable(i));
        }
        threadPoolExecutor.shutdown();
    }


    class TaskRunnable implements Runnable {

        private int currentLine;

        public TaskRunnable(int currentLine) {
            this.currentLine = currentLine;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("人数更新至数据库:" + currentLine);
        }

        int getCurrentLine() {
            return currentLine;
        }
    }

    class MaxRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            int currentTask = ((TaskRunnable) r).getCurrentLine();
            Runnable runnable = executor.getQueue().poll();
            if (runnable != null) {
                TaskRunnable queueTask = (TaskRunnable) runnable;
                if (currentTask > queueTask.getCurrentLine()) {
                    executor.getQueue().offer(r);
                } else {
                    executor.getQueue().offer(queueTask);
                }
            }

        }
    }


}


