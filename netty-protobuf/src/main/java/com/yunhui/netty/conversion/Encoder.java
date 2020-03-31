package com.yunhui.netty.conversion;

import com.yunhui.netty.proto.TransmissionProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Date : 2019-12-27 17:48
 * @Author : dushaoyun
 */
public class Encoder extends MessageToByteEncoder {


    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        TransmissionProtocol.TransmissionMsg request = (TransmissionProtocol.TransmissionMsg) msg;
        byte[] body = request.toByteArray();
        //读取消息的长度
        int dataLength = body.length;
        //先将消息长度写入，也就是消息头
        out.writeInt(dataLength);
        //消息体中包含我们要发送的数据
        out.writeBytes(body);
    }
}
