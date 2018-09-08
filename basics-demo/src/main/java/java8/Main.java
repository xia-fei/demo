package java8;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 夏飞
 */
public class Main {
    @Test
    public void testStream(){
        List<Integer> numberList=Lists.newArrayList(10,2,3,4,5,6);
       List<Integer> result=numberList.stream().map(a->a+3).collect(Collectors.toList());
        numberList.sort(Main::a);
        numberList.forEach(System.out::println);
        new Thread(()-> System.out.print("hello,thread")).start();
    }

    public static int a(int i,int j){
        return Integer.compare(i,j);
    }
}
