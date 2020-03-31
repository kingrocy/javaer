package com.yunhui.pmml;

import org.dmg.pmml.FieldName;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Date : 2019-10-11 13:50
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class FieldMap implements Map {
    private Map<FieldName, ?> map;

    FieldMap(Map<FieldName, ?> map) {
        this.map = map;
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException();
        } else {
            return this.map.containsKey(FieldName.create((String)key));
        }
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public Object get(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException();
        } else {
            return this.map.get(FieldName.create((String)key));
        }
    }

    public Object put(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public Collection values() {
        return this.map.values();
    }

    public Set entrySet() {
        return this.map.entrySet();
    }
}