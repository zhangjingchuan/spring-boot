package com.mangmangbang.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * created by zhangjingchuan on 2019/8/20
 *
 * 初始化器，channel注册后，会执行里面的相应的初始化方法
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //通不过socketchannel获取对应的管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //通过管道添加handler
        //HttpServerCodec 是由netty自己提供的助手类
        //当请求到服务端，我们需要做解码，相应到客户端做编码
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        //添加自定义的助手类，返回hello netty
        pipeline.addLast("CustomHandler",new CustomHandler());
    }
}
