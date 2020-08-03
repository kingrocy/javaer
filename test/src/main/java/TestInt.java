/**
 * @Date : 2020/7/24 11:21 上午
 * @Author : dushaoyun
 */
public class TestInt {

    public static void main(String[] args) {
        TestInt testInt=new TestInt();
        Integer i=new Integer(10);
        testInt.fun(i);
        System.out.println(i);
    }

    public void fun(Integer i){
        i=i+1;
        System.out.println(i);
    }
}
