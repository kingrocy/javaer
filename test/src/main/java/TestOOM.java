import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2020/7/17 9:47 上午
 * @Author : dushaoyun
 */
public class TestOOM {

    public static void main(String[] args) throws InterruptedException {
        List list=new ArrayList();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread.sleep(500);
            list.add(new byte[1024*1024]);
        }
        while (true){

        }
    }
}
