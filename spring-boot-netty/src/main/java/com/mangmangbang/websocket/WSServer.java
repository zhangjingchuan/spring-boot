package com.mangmangbang.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.boot.web.context.WebServerInitializedEvent;

/**
 * created by zhangjingchuan on 2019/10/12
 */
public class WSServer {

    public static void main(String [] args) throws Exception {

        //主线程组
        EventLoopGroup mainGroup = new NioEventLoopGroup();

        //从线程组
        EventLoopGroup subGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //创建服务
            serverBootstrap.group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WSServerInitializer());

            //绑定端口并启动
            ChannelFuture future = serverBootstrap.bind(9090).sync();

            future.channel().closeFuture().sync();
        }finally {
            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();
        }
    }


}
