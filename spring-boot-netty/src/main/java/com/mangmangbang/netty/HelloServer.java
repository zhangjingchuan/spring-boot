package com.mangmangbang.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * created by zhangjingchuan on 2019/8/20
 */
public class HelloServer {

    public static void main(String [] args) throws InterruptedException {

        //创建一对线程组，
        //主线程组，用于接受客户端的连接，但是不做任何处理，跟老板一样，不做事
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        //从线程组，老板线程组会把任务丢给他，让手下线程组去做任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //netty服务器的创建，serverBootstrap是一个启动累设置线程组
            serverBootstrap
                    //设置主从线程
                    .group(bossGroup, workerGroup)
                    //定义频道类型
                    .channel(NioServerSocketChannel.class)
                    //子处理器
                    .childHandler(new HelloServerInitializer());

            //启动server，设置端口为8088，同时启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            //监听关闭的channel，设置成同步关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
