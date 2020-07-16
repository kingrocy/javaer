package com.yunhui.arithmetic.floyd;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date : 2020/7/15 4:33 下午
 * @Author : dushaoyun
 */
public class FloydYun<T> {

    //    表示无穷大 即不可达
    private static int MAX = Integer.MAX_VALUE;
    /**
     * 距离矩阵
     */
    private int[][] dist;
    /**
     * 路径Path矩阵
     */
    private int[][] path;

    private Map<T, Integer> nodeIndex = new HashMap<>();

    private List<T> nodes;

    public FloydYun(List<T> nodes) {
        this.nodes = nodes;
        int size = nodes.size();
        this.path = new int[size][size];
        this.dist = new int[size][size];
        //给每个节点编个号
        int index = 0;
        for (T node : nodes) {
            nodeIndex.put(node, index++);
        }
    }

    /**
     * 添加一条边
     *
     * @param pre
     * @param next
     */
    public void addEdge(T pre, T next) {
        dist[nodeIndex.get(pre)][nodeIndex.get(next)] = 1;
    }

    /**
     * 构建路径矩阵
     */
    public void /**/floyd() {
        //完善dist 将dist中不可达的两点的值设置为MAX 代表无穷大 不可达
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (i != j && dist[i][j] == 0) {
                    dist[i][j] = MAX;
                }
            }
        }
        //初始化 path 路径矩阵
        int size = dist.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path[i][j] = -1;
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    //判断如果 ik距离可达且 kj距离可达 且 i和j的距离是否大于 i-> k 与 k->j的距离和
                    if (dist[i][k] != MAX && dist[k][j] != MAX && dist[i][j] > (dist[i][k] + dist[k][j])) {
                        path[i][j] = k;
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    /**
     * 查找路径
     */
    public List<T> findPath(T pre, T next) {
        print(dist);
        print(path);
        int l = Math.min(nodeIndex.get(pre), nodeIndex.get(next));
        int r = Math.max(nodeIndex.get(pre), nodeIndex.get(next));
        //查找路径 从r->l
        List list = new ArrayList();
        list.add(nodes.get(r));
        dofind(l, r, list);
        list.add(nodes.get(l));
        return list;
    }

    public void dofind(int l, int r, List<T> list) {
        if (path[l][r] != -1) {
            int mid = path[l][r];
            list.add(nodes.get(mid));
            dofind(l,mid,list);
        }
    }

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


        FloydYun floydYun = new FloydYun(nodes);

        //表关联关系可以是双
        for (JoinItem item : items) {
            floydYun.addEdge(item.getSourceId(), item.getTargetId());
            floydYun.addEdge(item.getTargetId(), item.getSourceId());
        }
        floydYun.floyd();
        List<Integer> path = floydYun.findPath(622, 628);
        StringBuffer pathStr = new StringBuffer();
        for (Integer integer : path) {
            pathStr.append(integer).append("->");
        }
        System.out.println(pathStr.toString().substring(0, pathStr.length() - 2));
    }

    public static void print(int[][] arrs) {
        System.out.println("------------------------");
        for (int[] arr : arrs) {
            for (int a : arr) {
                if (a == FloydDemo.MAX) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(a + " ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}
