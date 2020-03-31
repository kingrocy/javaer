package com.yunhui.netty.test;

import com.yunhui.netty.conversion.Decoder;
import com.yunhui.netty.conversion.Encoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Date : 2019-12-27 16:26
 * @Author : dushaoyun
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        System.out.println("服务端启动中");
//                        ch.pipeline().addLast("decoder", new ProtobufVarint32FrameDecoder());
//                        ch.pipeline().addLast("encoder", new ProtobufVarint32LengthFieldPrepender());
                        ch.pipeline().addLast("decoder", new Decoder());
                        ch.pipeline().addLast("encoder", new Encoder());
                        ch.pipeline().addLast("handler", new FirstServerHandler());
                    }
                });

        serverBootstrap.bind(8080).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口绑定成功!");
            } else {
                System.err.println("端口绑定失败!");
            }
        });
    }
}
