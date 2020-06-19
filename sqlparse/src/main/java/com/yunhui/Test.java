package com.yunhui;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

/**
 * @Date : 2020/6/17 3:42 下午
 * @Author : dushaoyun
 */
public class Test {

    @org.junit.Test
    public void test1(){
        String sql="show tables";
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.HIVE);
        SQLStatement sqlStatement = sqlStatements.get(0);
        System.out.println(sqlStatement.getClass().getName());
    }
}
