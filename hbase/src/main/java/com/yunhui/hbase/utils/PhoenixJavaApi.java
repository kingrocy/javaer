package com.yunhui.hbase.utils;

import com.alibaba.fastjson.JSON;

import java.sql.*;

/**
 * @Date : 2020/8/13 10:39 上午
 * @Author : dushaoyun
 */
public class PhoenixJavaApi {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载数据库驱动
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");

        /*
         * 指定数据库地址,格式为 jdbc:phoenix:Zookeeper 地址
         * 如果 HBase 采用 Standalone 模式或者伪集群模式搭建，则 HBase 默认使用内置的 Zookeeper，默认端口为 2181
         */
        Connection connection = DriverManager.getConnection("jdbc:phoenix:10.81.74.88:2181");

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM us_population");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("city") + " "
                    + resultSet.getInt("population"));
        }

        statement.close();
        connection.close();

    }
}
