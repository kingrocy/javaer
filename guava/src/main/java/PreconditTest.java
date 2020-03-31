import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import org.junit.Test;

/**
 * @Date : 2019-07-25 16:39
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class PreconditTest {


    @Test
    public void test1() {
        Preconditions.checkArgument(false,"occur exception",1024);
    }
}
