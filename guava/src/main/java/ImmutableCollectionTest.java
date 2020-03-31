import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import org.junit.Test;

/**
 * @Date : 2019-07-25 17:11
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class ImmutableCollectionTest {


    @Test
    public void test1() {

        ImmutableSortedMap<String, String> of = ImmutableSortedMap.of("k3", "v3", "k2", "v2");

        System.out.println(of);

    }


    @Test
    public void test2() {

    }


}
