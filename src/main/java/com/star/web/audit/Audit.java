package com.star.web.audit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author SWUST
 */
@Data
public class Audit {
    @NotNull(message = "用户名不能为空")
    Long userId;

    @NotNull(message = "退款金额")
    Integer refundMoney;

    @NotBlank(message = "支付订单号")
    String payNumber;
}
