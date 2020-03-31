package com.yunhui.zk.lock;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.apache.log4j.Logger;
import java.io.UnsupportedEncodingException;

/**
 * @author: alex
 * @Date: 2019/4/8
 * @Description: 序列化
 */
public class MyZkSerializer implements ZkSerializer {

    protected static Logger logger = Logger.getLogger(MyZkSerializer.class);

    /**
     * 反序列化
     * @param bytes 字节数组
     * @return 实体
     * @throws ZkMarshallingError
     */
    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("MyZkSerializer deserialize happened unsupportedEncodingException...");
            logger.error(e);
            throw new ZkMarshallingError(e);
        }
    }

    /**
     * 序列化
     * @param obj 实体
     * @return 字节数组
     * @throws ZkMarshallingError
     */
    @Override
    public byte[] serialize(Object obj) throws ZkMarshallingError {
        try {
            return String.valueOf(obj).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("MyZkSerializer serialize happened unsupportedEncodingException...");
            logger.error(e);
            throw new ZkMarshallingError(e);
        }
    }
}