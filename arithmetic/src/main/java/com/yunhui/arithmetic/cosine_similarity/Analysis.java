package com.yunhui.arithmetic.cosine_similarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date : 2019-06-19 17:01
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Analysis {

    public static void main(String[] args) {
        Map<String, int[]> resultMap = new HashMap<>();
        //测试文本
        String text1 = "你好，我是小王，我是个程序员";
        String text2 = "你好，我是设计师";

        List<String> list1 = IKUtils.divideText(text1);
        List<String> list2 = IKUtils.divideText(text2);
        //统计
        statistics(resultMap, list1, 1);
        statistics(resultMap, list2, 0);
        //计算类
        final Calculation calculation = new Calculation();
        resultMap.forEach((k, v) -> {
            int[] arr = resultMap.get(k);
            calculation.setNumerator(calculation.getNumerator() + arr[0] * arr[1]);
            calculation.setElementA(calculation.getElementA() + arr[0] * arr[0]);
            calculation.setElementB(calculation.getElementB() + arr[1] * arr[1]);
        });

        System.out.println("文本相似度：" + calculation.result());
    }

    /**
     * 组合词频向量
     *
     * @param words
     * @param direction
     * @return
     */
    private static void statistics(Map<String, int[]> map, List<String> words, int direction) {
        if (null == words || words.size() == 0) {
            return;
        }
        int[] in = null;
        boolean flag = direction(direction);
        for (String word : words) {
            int[] wordD = map.get(word);
            if (null == wordD) {
                if (flag) {
                    in = new int[]{1, 0};
                } else {
                    in = new int[]{0, 1};
                }
                map.put(word, in);
            } else {
                if (flag) {
                    wordD[0]++;
                } else {
                    wordD[1]++;
                }
            }
        }
    }

    //判断不同句子
    private static boolean direction(int direction) {
        return direction == 1 ? true : false;
    }
}
