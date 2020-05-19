package com.yunhui.calcite.simple.table;

import com.yunhui.calcite.simple.data.MemoryData;
import com.yunhui.calcite.simple.enumerator.MemoryEnumerator;
import org.apache.calcite.DataContext;
import org.apache.calcite.linq4j.AbstractEnumerable;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.ScannableTable;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.sql.type.SqlTypeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2020/4/14 3:23 下午
 * @Author : dushaoyun
 */
public class MemoryTable extends AbstractTable implements ScannableTable {
    private MemoryData.Table sourceTable;
    private RelDataType dataType;

    public MemoryTable(MemoryData.Table table) {
        this.sourceTable = table;
        dataType = null;
    }

    @Override
    public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        if (dataType == null) {
            synchronized (this) {
                if (dataType == null) {
                    RelDataTypeFactory.FieldInfoBuilder fieldInfo = typeFactory.builder();
                    for (MemoryData.Column column : this.sourceTable.columns) {
                        RelDataType sqlType = typeFactory.createJavaType(
                                MemoryData.JAVATYPE_MAPPING.get(column.type));
                        sqlType = SqlTypeUtil.addCharsetAndCollation(sqlType, typeFactory);
                        fieldInfo.add(column.name, sqlType);
                    }
                    dataType = typeFactory.createStructType(fieldInfo);
                }
            }
        }
        return dataType;
    }

    @Override
    public Enumerable<Object[]> scan(DataContext root) {
        final List<String> types = new ArrayList<String>(sourceTable.columns.size());
        for (MemoryData.Column column : sourceTable.columns) {
            types.add(column.type);
        }
        final int[] fields = identityList(this.getRowType(root.getTypeFactory()).getFieldCount());
        return new AbstractEnumerable<Object[]>() {
            @Override
            public Enumerator<Object[]> enumerator() {
                return new MemoryEnumerator<>(fields, types, sourceTable.data);
            }
        };
    }

    private static int[] identityList(int n) {
        int[] integers = new int[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i;
        }
        return integers;
    }
}