/**
 * @Date : 2019-07-24 17:39
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class TestStackOverFlow {

    public void test(){
        while(true){
            System.out.println("hello wolrd");
        }
    }

    public static void main(String[] args) {
        TestStackOverFlow main=new TestStackOverFlow();
        main.test();
    }

}
