package com.mangmangbang.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.SocketAddress;
import java.nio.charset.Charset;

/**
 * created by zhangjingchuan on 2019/8/20
 *
 * 自定义助手类
 *
 * SimpleChannelInboundHandler对于请求来讲，其实相当于入栈入境
 */
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        //获取channel
        Channel channel = channelHandlerContext.channel();

        if(httpObject instanceof HttpRequest) {
            //客户端远程地址
            SocketAddress socketAddress = channel.remoteAddress();
            System.out.println(socketAddress);

            //定义发送的数据消息
            //缓冲区
            ByteBuf content = Unpooled.copiedBuffer("hello netty", CharsetUtil.UTF_8);

            //构建一个相应
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            response.headers()
                    //数据类型
                    .set(HttpHeaderNames.CONTENT_TYPE, "text/plain")
                    //数据长度
                    .set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            //写入缓存区同时刷到客户端
            channelHandlerContext.writeAndFlush(response);

        }
    }
}
