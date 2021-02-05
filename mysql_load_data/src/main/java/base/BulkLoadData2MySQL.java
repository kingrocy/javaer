package base;

import org.springframework.jdbc.core.JdbcTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Date : 2021/2/5 4:08 下午
 * @Author : dushaoyun
 */
public class BulkLoadData2MySQL {


    private JdbcTemplate jdbcTemplate;

    private Connection conn = null;

    public static InputStream getTestDataInputStream() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10000; j++) {
                builder.append(4);
                builder.append("\t");
                builder.append(4 + 1);
                builder.append("\t");
                builder.append(4 + 2);
                builder.append("\t");
                builder.append(4 + 3);
                builder.append("\t");
                builder.append(4 + 4);
                builder.append("\t");
                builder.append(4 + 5);
                builder.append("\n");
            }
        }
        byte[] bytes = builder.toString().getBytes();
        InputStream is = new ByteArrayInputStream(bytes);
        return is;
    }


    public int bulkLoadFromInputStream(String loadDataSql, InputStream dataStream) throws SQLException {
        if (dataStream == null) {
            return 0;
        }
        conn = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement statement = conn.prepareStatement(loadDataSql);
        int result = 0;
        if (statement.isWrapperFor(com.mysql.jdbc.Statement.class)) {
            com.mysql.jdbc.PreparedStatement mysqlStatement = statement.unwrap(com.mysql.jdbc.PreparedStatement.class);
            mysqlStatement.setLocalInfileInputStream(dataStream);
            result = mysqlStatement.executeUpdate();
        }
        return result;
    }


    public static void main(String[] args) {
        String testSql = "LOAD DATA LOCAL INFILE 'sql.csv' IGNORE INTO TABLE test.test (a,b,c,d,e,f)";
        InputStream dataStream = getTestDataInputStream();
        BulkLoadData2MySQL dao = new BulkLoadData2MySQL();
        try {
            long beginTime = System.currentTimeMillis();
            int rows = dao.bulkLoadFromInputStream(testSql, dataStream);
            long endTime = System.currentTimeMillis();
            System.out.println("importing " + rows +
                    " rows data into mysql and cost " + (endTime - beginTime) +
                    " ms!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
