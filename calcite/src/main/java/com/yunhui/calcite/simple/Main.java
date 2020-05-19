package com.yunhui.calcite.simple;

import java.sql.*;
import java.util.Properties;

/**
 * @Date : 2020/4/14 3:27 下午
 * @Author : dushaoyun
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.apache.calcite.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Properties info = new Properties();
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:calcite:model=/Users/dushaoyun/work/workspace/java/yun/javaer/calcite/src/main/resources/School.json", info);
            ResultSet result = connection.getMetaData().getTables(null, null, null, null);
            while (result.next()) {
                System.out.println("Catalog : " + result.getString(1) + ",Database : " + result.getString(2) + ",Table : " + result.getString(3));
            }
            result.close();

            Statement st = connection.createStatement();
            result = st.executeQuery("select \"home\" ,1, count(1) from \"Student\" as S INNER JOIN \"Class\" as C on S.\"classId\" = C.\"id\" group by \"home\"");
            while (result.next()) {
                System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
            }
            result.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
