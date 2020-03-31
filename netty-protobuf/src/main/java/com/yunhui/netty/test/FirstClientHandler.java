package com.yunhui.netty.test;

import com.yunhui.netty.proto.TransmissionProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Date : 2019-12-27 16:35
 * @Author : dushaoyun
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端写出数据");
        // 1. 获取数据
//        ByteBuf buffer = getByteBuf(ctx);
        TransmissionProtocol.TransmissionMsg transmissionMsg = gettransmissionMsg();
        // 2. 写数据
        ctx.channel().writeAndFlush(transmissionMsg);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client receive msg:" + msg);
        TransmissionProtocol.TransmissionMsg transmissionMsg = (TransmissionProtocol.TransmissionMsg) msg;
        System.out.println(new Date() + ": 客户端读到数据 -> " + transmissionMsg);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1. 获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 2. 准备数据，指定字符串的字符集为 utf-8
        byte[] bytes = "你好，闪电侠!".getBytes(Charset.forName("utf-8"));
        // 3. 填充数据到 ByteBuf
        buffer.writeBytes(bytes);
        return buffer;
    }

    private TransmissionProtocol.TransmissionMsg gettransmissionMsg() {
        return TransmissionProtocol.TransmissionMsg.newBuilder().setStatus(TransmissionProtocol.Status.SUCCESS).setType(TransmissionProtocol.Type.PING)
                .addRequest(TransmissionProtocol.Request.newBuilder()
                        .setKey("name").setValue("dusy").build())
                .addRequest(TransmissionProtocol.Request.newBuilder()
                        .setKey("sex").setValue("man").build()).build();
    }
}
