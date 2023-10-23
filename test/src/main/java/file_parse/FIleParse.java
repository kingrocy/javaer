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

            Set<Long> userIdList = Sets.newHashSet();

            Set<String> deviceIdList = Sets.newHashSet();

            Set<String> modList = Sets.newHashSet();

            // read until end of file
            String line;
            while ((line = br.readLine()) != null) {


                if (!StringUtils.isEmpty(line)) {
                    JSONObject jsonObject = JSON.parseObject(line);

                    JSONObject source = jsonObject.getJSONObject("_source");


                    String msg = source.getString("msg");


                    int start = msg.indexOf("{");
                    int end = msg.indexOf("com.kuaishou.encryptid.exception.DecryptIdCommonException");

                    String substring = msg.substring(start, end);

                    JSONObject object = JSON.parseObject(substring);

                    JSONObject clientRequestInfo = object.getJSONObject("clientRequestInfo");

                    Long userId = clientRequestInfo.getLong("userId");


                    userIdList.add(userId);

                    String deviceId = clientRequestInfo.getString("deviceId");


                    deviceIdList.add(deviceId);


                    String logtime = source.getString("logtime");

                    modList.add(Joiner.on(" ").join(logtime, userId));
                }

            }

            // close the reader
            br.close();

            //            for (Long userId : userIdList) {
            //                System.out.println(userId);
            //            }

            //
            //            for (String deviceId : deviceIdList) {
            //                System.out.println(deviceId);
            //            }

            for (String mod : modList) {
                System.out.println(mod);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}
