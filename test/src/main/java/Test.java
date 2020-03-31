import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @Date : 2019-06-19 15:03
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Test {

    static final int MAXIMUM_CAPACITY = 1 << 30;




    @org.junit.Test
    public void test1(){

        int [] array=new int[]{1,2,3,4,5};

//        int [] copy= Arrays.copyOf(array, array.length);
//        int [] copy= Arrays.copyOfRange(array,0, array.length);

        int [] copy=new int[5];


        System.arraycopy(array, 0, copy,0 , 5);


        for (int i : copy) {
            System.out.println(i);
        }
    }


    @org.junit.Test
    public void test2(){
        System.out.println(Math.sqrt(0.6));

    }



    @org.junit.Test
    public void test3(){
        Map<String,Object> params=new HashMap<>();

        //根据这个参数做AB测试 如果为null  不做AB
        params.put("AucId", "10078701");


        params.put("BasePrice", 1002000);
        params.put("ScBrandID", "brand-27");
        params.put("ScSeriesID", "series-1728");
        params.put("CarAge", 0);
        params.put("EmissionStandard", "排放不详");
        params.put("RankLevel", 95);
        params.put("RankDesc", "A");
        params.put("ScCarModelID", "227446");
        params.put("cityCode", "00002");


        System.out.println(JSON.toJSONString(params));

    }


    @org.junit.Test
    public void test4(){

        System.out.println(MAXIMUM_CAPACITY);

        System.out.println(tableSizeFor(13));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }



    @org.junit.Test
    public void test5(){
        List<Integer> list= Lists.newArrayList(1,2,3,4,5);
        for (Integer integer : list) {
            System.out.println(integer);
            if(integer==3){
                list.remove(integer);
            }
        }
    }


    @org.junit.Test
    public  void test6(){
        Hashtable<Integer,Integer> hashtable=new Hashtable();

        hashtable.put(1, 1);
        hashtable.put(2, 2);
        hashtable.put(3, 3);
        hashtable.put(4, 4);


        hashtable.forEach((x,y)->{
            System.out.println("key:"+x+",value:"+y);
            if(x.equals(3)){
                hashtable.remove(x);
            }
        });
    }


    @org.junit.Test
    public void test7(){
        System.out.println(3^6);
    }


    @org.junit.Test
    public void test8(){
        System.out.println(1^3);
    }
}
