package com.star.common.enums.gf.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zt
 * @date 2022/12/6 11:03
 */
@AllArgsConstructor
@Getter
public enum MessageType {
    服务抄送(0),
    关爱建议(1),
    站点公告(2),
    内部公告(3),
    阶段计划审核(4),
    强制报告审核(5),
    学习内容审核(6),
    转接消息(7);
    private int code;

    /**
     * 获取对应值
     * @param value
     * @return
     */
//    public static MessageType getType(Object value) {
//        if (value instanceof OrgType){
//            return getMessageTypeByOrgType((OrgType) value);
//        }
//        return MessageType.服务消息_未成年;
//    }
//
//    private static MessageType getMessageTypeByOrgType(OrgType value) {
//        switch (value){
//            case 社工站:
//            case 为老机构:
//            case 养老机构:
//            case 区级单位:
//            case 社会组织:
//            case 法人社会组织:
//            case 社区社会组织:
//        }
//    }
}
