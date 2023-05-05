package com.star.web.audit;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author SWUST
 */
public abstract class AuditHandler {

    protected AuditHandler next;

    /**
     * 下一个校验
     * @param next
     */
    private void next(AuditHandler next) {
        this.next = next;
    }

    public abstract void doHandler(Audit audit);

    public static class Builder {
        private AuditHandler head;
        private AuditHandler tail;

        public Builder addHandler(AuditHandler handler) {
            if (ObjectUtil.isNotNull(this.head)) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public AuditHandler build() {
            return this.head;
        }

        // Handler.Builder builder = new Handler.Builder();
        // //链式编程，谁在前谁在后看的清清楚楚
        // builder.addHandler(new ValidateHandler())
        //         .addHandler(new LoginHandler())
        //         .addHandler(new AuthHandler())
        //         .addHandler(new BusinessLogicHandler());

        // builder.build().doHandler(user);
    }
}
