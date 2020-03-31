package com.yunhui.netty.test;

import com.yunhui.netty.proto.TransmissionProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Date : 2019-12-27 16:37
 * @Author : dushaoyun
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("server receive msg:" + msg);
        TransmissionProtocol.TransmissionMsg transmissionMsg = (TransmissionProtocol.TransmissionMsg) msg;
        System.out.println(new Date() + ": 服务端读到数据 -> " +transmissionMsg);
        // 回复数据到客户端
        System.out.println(new Date() + ": 服务端写出数据");
//        ByteBuf out = getByteBuf(ctx);
        TransmissionProtocol.TransmissionMsg transmissionMsg2 = gettransmissionMsg();
        ctx.channel().writeAndFlush(transmissionMsg2);
    }


    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，欢迎关注我的微信公众号，《闪电侠的博客》!".getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
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