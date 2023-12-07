package file_parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

/**
 *
 * Created on 2022-08-09
 */
public class FIleParse {

    public static void main(String[] args) {


        try {
            // create a reader instance
            BufferedReader br = new BufferedReader(new FileReader("/Users/dushaoyun/kuaishou/work/workspace/souche "
                    + "backup/workspace/java/yun/javaer/test/src/main/resources/test.file"));

            Set<Long> cateId_1 = Sets.newHashSet();
            Set<Long> cateId_2 = Sets.newHashSet();
            Set<Long> cateId_3 = Sets.newHashSet();

            Set<Long> itemIds = Sets.newHashSet();
            Set<Long> promoters = Sets.newHashSet();


            // read until end of file
            String line;
            while ((line = br.readLine()) != null) {


                if (!StringUtils.isEmpty(line)) {
                    JSONObject jsonObject = JSON.parseObject(line);

                    JSONObject source = jsonObject.getJSONObject("_source");


                    String msg = source.getString("msg");


                    int start = msg.indexOf("{");
                    int end = msg.indexOf("response");

                    String substring = msg.substring(start, end);

                    JSONObject object = JSON.parseObject(substring);

                    String attributes = object.getString("attributes");

                    DeliveryRecallAttribute deliveryRecallAttribute = JSON.parseObject(attributes, DeliveryRecallAttribute.class);

                    cateId_1.add(deliveryRecallAttribute.getCate1_id());
                    cateId_2.add(deliveryRecallAttribute.getCate3_id());
                    cateId_3.add(deliveryRecallAttribute.getLeaf_cate_id());

                    itemIds.add(deliveryRecallAttribute.getItem_id());
                    promoters.add(deliveryRecallAttribute.getPromoter_id());
                }

            }

            // close the reader
            br.close();

            //            System.out.println("一级类目id：========================开始===========================");
            //            for (Long mod : cateId_1) {
            //                System.out.println(mod);
            //            }
            //            System.out.println("一级类目id：========================结束===========================");
            //
            //
            //            System.out.println("二级类目id：========================开始===========================");
            //            for (Long mod : cateId_2) {
            //                System.out.println(mod);
            //            }
            //            System.out.println("二级类目id：========================结束===========================");
            //
            //            System.out.println("叶子类目id：========================开始===========================");
            //            for (Long mod : cateId_3) {
            //                System.out.println(mod);
            //            }
            //            System.out.println("叶子类目id：========================结束===========================");


            System.out.println("商品id：========================开始===========================");
            for (Long mod : itemIds) {
                System.out.println(mod);
            }
            System.out.println("商品id：========================结束===========================");

            System.out.println("达人：：========================开始===========================");
            for (Long mod : promoters) {
                System.out.println(mod);
            }
            System.out.println("达人：========================结束===========================");

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}
