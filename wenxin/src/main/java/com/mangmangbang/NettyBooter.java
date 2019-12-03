package com.mangmangbang;

import com.mangmangbang.netty.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * created by zhangjingchuan on 2019/10/11
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 监听springboot启动事件，启动成功后，启动netty
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent()==null){
            try {
                WSServer.getInstance().start();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
