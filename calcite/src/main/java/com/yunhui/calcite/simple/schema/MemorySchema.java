package com.yunhui.calcite.simple.schema;

import com.yunhui.calcite.simple.data.MemoryData;
import com.yunhui.calcite.simple.table.MemoryTable;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/4/14 3:19 下午
 * @Author : dushaoyun
 */
public class MemorySchema extends AbstractSchema {

    private String dbName;

    public MemorySchema(String dbName) {
        this.dbName = dbName;
    }

    @Override
    protected Map<String, Table> getTableMap() {
        Map<String, Table> tables = new HashMap<>();
        MemoryData.Database database = MemoryData.MAP.get(this.dbName);
        if (database == null) {
            return tables;
        }
        for (MemoryData.Table table : database.tables) {
            tables.put(table.tableName, new MemoryTable(table));
        }
        return tables;
    }
}
