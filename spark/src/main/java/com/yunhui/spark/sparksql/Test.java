package com.yunhui.spark.sparksql;

import org.apache.spark.sql.SparkSession;

/**
 * @Date : 2019-06-25 10:50
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {


        String warehouseLocation = "/user/hive/warehousee";
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark Hive Example")
                .master("local[*]")
                .config("spark.sql.warehouse.dir", warehouseLocation)
                .enableHiveSupport()
                .getOrCreate();

        spark.sql("SELECT * FROM school.student").show();

    }
}
