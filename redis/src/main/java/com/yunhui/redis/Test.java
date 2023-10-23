package com.yunhui.redis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 *
 * Created on 2021-05-19
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        String path =
                "/Users/dushaoyun/kuaishou/work/workspace/souche "
                        + "backup/workspace/java/yun/javaer/redis/src/main/java/com/yunhui/redis/note.txt";

        FileInputStream fileInputStream = new FileInputStream(new File(path));

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String s = bufferedReader.readLine();
            System.out.println(s.split(",").length);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
