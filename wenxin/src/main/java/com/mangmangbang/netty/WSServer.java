package com.mangmangbang.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * created by zhangjingchuan on 2019/8/20
 */
@Component
public class WSServer {


    //设置单例模式
    private static class SingletionWSServer{
        static final WSServer instance = new WSServer();
    }

    public static WSServer getInstance(){
        return SingletionWSServer.instance;
    }

    //定义基本属性
    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap serverBootstrap;
    private ChannelFuture channelFuture;

    public WSServer(){
        mainGroup = new NioEventLoopGroup();

        //从线程组，老板线程组会把任务丢给他，让手下线程组去做任务
        subGroup = new NioEventLoopGroup();

        serverBootstrap = new ServerBootstrap();
        //netty服务器的创建，serverBootstrap是一个启动累设置线程组
        serverBootstrap
                //设置主从线程
                .group(mainGroup, subGroup)
                //定义频道类型
                .channel(NioServerSocketChannel.class)
                //子处理器
                .childHandler(new WSServerInitializer());
    }

    /**
     * 启动服务
     */
    public void start(){

        channelFuture = serverBootstrap.bind(9090);
        //打印信息
        System.err.println("netty websocket server 已启动");
    }


}
