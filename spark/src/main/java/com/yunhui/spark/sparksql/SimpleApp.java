package com.yunhui.spark.sparksql;

/**
 * @Date : 2019-06-25 14:09
 * @Author :
 * @CopyRight :
 * @Desc :
 */
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;

public class SimpleApp {
    public static void main(String[] args) {

        String logFile = "/Users/dushaoyun/test/test.log";

        SparkSession spark = SparkSession.builder().master("local").appName("Simple Application").getOrCreate();

        Dataset<String> logData = spark.read().textFile(logFile).cache();

        long numAs = logData.filter(s -> s.contains("a")).count();
        long numBs = logData.filter(s -> s.contains("b")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }
}