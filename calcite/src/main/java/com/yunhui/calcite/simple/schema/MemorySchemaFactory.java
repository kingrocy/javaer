package com.yunhui.calcite.simple.schema;

import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

import java.util.Map;

/**
 * @Date : 2020/4/14 3:19 下午
 * @Author : dushaoyun
 */
public class MemorySchemaFactory implements SchemaFactory {

    @Override
    public Schema create(SchemaPlus parentSchema, String name, Map<String, Object> operand) {
        System.out.println("param1 : " + operand.get("param1"));
        System.out.println("param2 : " + operand.get("param2"));

        System.out.println("Get database " + name);

        return new MemorySchema(name);
    }
}
