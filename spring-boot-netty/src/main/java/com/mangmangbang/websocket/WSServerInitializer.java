package com.mangmangbang.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * created by zhangjingchuan on 2019/10/12
 */
public class WSServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        //webSocket基于http协议，所以要有http编解码器
        pipeline.addLast(new HttpServerCodec())
                //对大数据流的写操作
                .addLast(new ChunkedWriteHandler())
                //http相关请求的聚合器（Request请求，Response请求），对httpMessage聚合成FullHttpRequest或FullHttpResponse
                //几乎在netty中的编程，都会使用到此handler
                .addLast(new HttpObjectAggregator(1024*64))
                /**
                 * websocket 服务器处理的协议，用于指定给客户端连接访问的路由 : /ws
                 * 本handler会帮你处理一些繁重的复杂的事
                 * 会帮你处理握手动作： handshaking（close, ping, pong） ping + pong = 心跳
                 * 对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
                 */
                .addLast(new WebSocketServerProtocolHandler("/ws"))
                //自定义的handler
                .addLast(new ChatHandler());

    }
}
