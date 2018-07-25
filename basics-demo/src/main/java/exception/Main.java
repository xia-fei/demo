package exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

/**
 * @author 夏飞
 */
public class Main {


    @Test
    public void test1(){
           try {
               Integer i=null;
               i.byteValue();
           }catch (RuntimeException e){
               System.out.println(ExceptionUtils.getStackFrames(e)[0]);
               System.out.println("----------------");
               System.out.println(ExceptionUtils.getStackFrames(e)[1]);
               System.out.println("----------------");
               System.out.println(ExceptionUtils.getRootCauseStackTrace(e)[0]);
               System.out.println("----------------");
               System.out.println(ExceptionUtils.getRootCauseStackTrace(e)[1]);
           }
    }


    private void exception(){
        try {
            throw new IllegalArgumentException();
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        try {
            new Main().exception();
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }
}
