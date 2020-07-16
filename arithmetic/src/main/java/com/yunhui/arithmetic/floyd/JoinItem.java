package com.yunhui.arithmetic.floyd;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date : 2020/7/15 4:02 下午
 * @Author : dushaoyun
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class JoinItem {

    private Integer sourceId;
    private Integer targetId;


    public static void main(String[] args) {

        List<JoinItem> items = Lists.newArrayList(
                new JoinItem(623, 625),
                new JoinItem(622, 625),
                new JoinItem(624, 625),
                new JoinItem(625, 626),
                new JoinItem(626, 627),
                new JoinItem(626, 628)
        );

        //筛选出所有的节点
        List<Integer> nodes = items.stream().flatMap(x -> Stream.of(x.getSourceId(), x.getTargetId())).distinct().sorted().collect(Collectors.toList());

        System.out.println(nodes);

        Map<Integer, Integer> nodeIndex = new LinkedHashMap<>();
        int index = 0;
        for (Integer node : nodes) {
            nodeIndex.put(node, index++);
        }

        //构建邻阶矩阵
        int size = nodes.size();
        int[][] matrix = new int[size][size];

        for (JoinItem item : items) {
            matrix[nodeIndex.get(item.getSourceId())][nodeIndex.get(item.getTargetId())] = 1;
            matrix[nodeIndex.get(item.getTargetId())][nodeIndex.get(item.getSourceId())] = 1;
        }

        //遍历矩阵 对于0-0  1-1  2-2置为0   不可达的元素置为Integer.MAXVALUE
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j && matrix[i][j] == 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        FloydDemo floydDemo = new FloydDemo(size);

        floydDemo.floyd(matrix);

        FloydDemo.print(floydDemo.dist);

        FloydDemo.print(floydDemo.path);

        floydDemo.findPath(nodeIndex.get(622), nodeIndex.get(628));

    }

}
