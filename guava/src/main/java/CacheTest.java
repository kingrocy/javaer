import com.google.common.cache.*;
import com.google.common.collect.ImmutableMap;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Date : 2019-07-25 17:29
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class CacheTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ImmutableMap<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2", "k3", "v3");


        LoadingCache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(100)
                //设置cache里面的所有k,v 在写之后，多少时间过期（过期策略为惰性移除 当调用get方法时 进行回收）
                .expireAfterWrite(3, TimeUnit.SECONDS)
                //设置cache里面的所有kv 在被读之后，多少时间过期 同理 也是惰性移除
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .removalListener(removalNotification -> System.out.println("删除原因:"+removalNotification.getCause()+",删除key:"+removalNotification.getKey()+"，删除value:"+removalNotification.getValue()))
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String s) throws Exception {
                        System.out.println("load,s:"+s+",date:"+new Date());
                        return map.get(s);
                    }
                });

        System.out.println(cache.get("k1"));
        System.out.println(cache.get("k2"));

        while (true){
            System.out.println(cache.get("k1"));
            Thread.sleep(1000*3);
        }
    }
}
