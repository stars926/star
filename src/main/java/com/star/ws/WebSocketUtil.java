package com.star.ws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketUtil {

    private final WebSocketServer webSocketServer;

    // /**
    //  * 通知WEB 计算结果
    //  *
    //  * @param projectResultDto 计算结果
    //  */
    // public boolean notifyWebCalculationResult(Long uid, DecProjectResultDto projectResultDto) {
    //
    //     WsCommonDTO wsCommonDTO = WsCommonDTO.builder()
    //         .dataType(WsMessageType.PLAN_RESULT.getCode())
    //         .data(JSONUtil.toJsonStr(projectResultDto))
    //         .build();
    //     return webSocketServer.sendMessageToWeb(uid, wsCommonDTO);
    // }
}
