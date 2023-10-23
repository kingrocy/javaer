package excel.impot;

import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;


/**
 *
 * Created on 2021-10-13
 */
public class Main {

    public static void main(String[] args) {

        String fileName = "/Users/dushaoyun/Downloads/挑战赛白名单 (10).xlsx";

        Integer sheetNumber = 15;

        boolean needDesc = false;

        //        String fileName = args[0];

        List<WhiteUser> whiteUserList = Lists.newArrayList();

        WhiteUserDataListener whiteUserDataListener = new WhiteUserDataListener(whiteUserList, needDesc);

        EasyExcel.read(fileName, WhiteUser.class,
                whiteUserDataListener).sheet(sheetNumber).doRead();

        //        ListUtils.partition(whiteUserList,2).forEach(x-> System.out.println(JSON.toJSONString(x)));

        System.out.println(JSON.toJSONString(whiteUserList));
    }
}
