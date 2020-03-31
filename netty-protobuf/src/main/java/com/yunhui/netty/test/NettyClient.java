package com.yunhui.netty.test;

import com.yunhui.netty.conversion.Decoder;
import com.yunhui.netty.conversion.Encoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Date : 2019-12-27 16:27
 * @Author : dushaoyun
 */
public class NettyClient {
    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                // 1.指定线程模型
                .group(workerGroup)
                // 2.指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
                // 3.IO 处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                        System.out.println("连接上服务器");
//                        ch.pipeline().addLast("decoder", new ProtobufVarint32FrameDecoder());
//                        ch.pipeline().addLast("encoder", new ProtobufVarint32LengthFieldPrepender());
                        ch.pipeline().addLast("decoder", new Decoder());
                        ch.pipeline().addLast("encoder", new Encoder());
                        ch.pipeline().addLast("handle", new FirstClientHandler());
                    }
                });
        // 4.建立连接
        bootstrap.connect("127.0.0.1", 8080).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
            } else {
                System.err.println("连接失败!");
            }
        });
    }
}
