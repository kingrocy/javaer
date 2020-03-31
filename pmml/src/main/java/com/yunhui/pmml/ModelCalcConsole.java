package com.yunhui.pmml;

import org.dmg.pmml.FieldName;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Date : 2019-10-11 13:50
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class ModelCalcConsole {
    public ModelCalcConsole() {
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Wrong arguments.");
        }

        String pmmlPath = args[0];
        String modelArgsFilePath = args[1];
        ModelInvoker invoker = new ModelInvoker(new FileInputStream(pmmlPath));
        List<Map<FieldName, Object>> paramList = readInParams(modelArgsFilePath);
        int lineNum = 0;
        Iterator var6 = paramList.iterator();

        while(var6.hasNext()) {
            Map<FieldName, Object> param = (Map)var6.next();
            ++lineNum;
            System.out.println("--------------------------------------- Num: " + lineNum + " -------------------------------------");
            Map<FieldName, ?> result = invoker.invoke(param);
            Set<FieldName> keySet = result.keySet();
            Iterator var10 = keySet.iterator();

            while(var10.hasNext()) {
                FieldName fn = (FieldName)var10.next();
                System.out.println(result.get(fn).toString());
            }

            System.out.println("--------------------------------------- Num: " + lineNum + " -------------------------------------");
        }

    }

    private static List<Map<FieldName, Object>> readInParams(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String[] nameArr = br.readLine().split(",");
        List<Map<FieldName, Object>> list = new ArrayList();
        String paramLine = null;

        while((paramLine = br.readLine()) != null) {
            Map<FieldName, Object> map = new HashMap();
            String[] paramLineArr = paramLine.split(",");

            for(int i = 0; i < paramLineArr.length; ++i) {
                map.put(FieldName.create(nameArr[i]), paramLineArr[i]);
            }

            list.add(map);
        }

        return list;
    }
}

