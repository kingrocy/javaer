import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @Date : 2019-07-25 15:48
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class OptionalTest {



    @Test
    public void test1(){

        String first=null;
        String second="hello world";

        String nonNull = MoreObjects.firstNonNull(first, second);

        System.out.println(nonNull);
    }

    @Test
    public void test2(){

        String first=null;
        String second="hello world";

        String or = Optional.fromNullable(first).or(second);

        System.out.println(or);
    }


}
