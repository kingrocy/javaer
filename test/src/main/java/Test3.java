import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @Date : 2020/10/15 3:47 下午
 * @Author : dushaoyun
 */
public class Test3 {


    public static void main(String[] args) {

        ThreadLocal<Integer> threadLocal=new ThreadLocal<>();

        CompletableFuture<Void> future1= CompletableFuture.runAsync(() -> {

            threadLocal.set(111);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<Integer> list1 = new ArrayList() {{
                add(threadLocal.get());
            }};

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当前线程1："+list1);
        });


        CompletableFuture<Void> future2= CompletableFuture.runAsync(() -> {

            threadLocal.set(222);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<Integer> list1 = new ArrayList() {{
                add(threadLocal.get());
            }};

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当前线程2："+list1);
        });


        CompletableFuture<Void> future3= CompletableFuture.runAsync(() -> {

            threadLocal.set(333);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<Integer> list1 = new ArrayList() {{
                add(threadLocal.get());
            }};

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当前线程3："+list1);
        });

        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
            while (true){
                new Thread(() -> {
                    Random random = new Random();
                    threadLocal.set(random.nextInt());
                }).start();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });


        CompletableFuture.allOf(future1,future2,future3,future4).join();
    }
}
