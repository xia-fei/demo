package java8;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 夏飞
 */
public class Main {


    @Test
    public void testStream2() {
        ListWarp listWarp = new ListWarp("parent");
        ListWarp listFirst = new ListWarp("first");
        ListWarp listSecond = new ListWarp("second");
        ListWarp listThird = new ListWarp("third");
        ListWarp listE1 = new ListWarp("e1");
        ListWarp listE2 = new ListWarp("e2");
        ListWarp listE3 = new ListWarp("e3");

        listThird.setChildren(Lists.newArrayList(listE1, listE2, listE3));
        listSecond.setChildren(Collections.singletonList(listThird));
        listFirst.setChildren(Collections.singletonList(listSecond));
        listWarp.setChildren(Collections.singletonList(listFirst));
        listWarp.getChildren().forEach(first -> {
            System.out.println(first.getName());
                    first.getChildren().forEach(second -> {
                        System.out.println(second.getName());
                        second.getChildren().forEach(third -> {
                            System.out.println(third.getName());
                            third.getChildren().forEach(e -> System.out.println(e.getName()));
                        });
                    });
                }
        );
    }

    public static int a(int i, int j) {
        return Integer.compare(i, j);
    }
}
