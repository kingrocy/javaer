import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Date : 2019-07-25 16:43
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class OrderingTest {


    @Test
    public void test1() {

        ArrayList<Integer> list = Lists.newArrayList(3, 2, 5, 4, 7, 9, 1);

        list.sort(Ordering.natural());

        System.out.println(list);
    }
}
