package com.star.ws;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Zyb
 */
@ServerEndpoint(value = "/ws")
@Component
@Slf4j
public class WebSocketServer {

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        log.info("onOpen");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        log.info("onClose");
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("onMessage");
    }

    /**
     * 出现异常调用方法
     */
    @OnError
    public void onError(Session session) {
        log.info("onError");
    }
}
