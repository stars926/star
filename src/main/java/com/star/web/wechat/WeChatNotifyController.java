// package com.star.web.wechat;
//
// import cn.hutool.core.date.DatePattern;
// import cn.hutool.core.date.DateUtil;
// import cn.hutool.core.map.MapUtil;
// import cn.hutool.core.util.IdUtil;
// import cn.hutool.core.util.ObjectUtil;
// import cn.hutool.core.util.StrUtil;
// import cn.hutool.json.JSONArray;
// import cn.hutool.json.JSONObject;
// import cn.hutool.json.JSONUtil;
// import cn.hutool.core.io.FileUtil;
// import cn.hutool.core.io.file.FileWriter;
// import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
// import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
// import com.gf.cloud.common.constant.ResponseCodeConstants;
// import com.gf.cloud.common.core.domain.entity.SysUser;
// import com.gf.cloud.common.enums.RecordStatus;
// import com.gf.cloud.common.enums.RecordType;
// import com.gf.cloud.common.enums.UserMoneyType;
// import com.gf.cloud.common.util.RedisUtils;
// import com.gf.cloud.common.util.ResponseUtils;
// import com.gf.cloud.common.util.Result;
// import com.gf.cloud.idempotent.annotation.RepeatSubmit;
// import com.gf.cloud.record.entity.GfRecordPayEntity;
// import com.gf.cloud.record.entity.GfRecordRefundEntity;
// import com.gf.cloud.record.mapper.GfRecordNotifyMapper;
// import com.gf.cloud.record.service.GfRecordPayService;
// import com.gf.cloud.record.service.GfRecordRefundService;
// import com.gf.cloud.system.mapper.SysUserMapper;
// import com.gf.cloud.wx.pay.config.WeChatPayProperty;
// import com.gf.cloud.wx.red.WeChatPayService;
// import com.gf.cloud.wx.red.entity.dto.PayUserInfoDto;
// import com.ijpay.core.IJPayHttpResponse;
// import com.ijpay.core.enums.RequestMethodEnum;
// import com.ijpay.core.kit.AesUtil;
// import com.ijpay.core.kit.PayKit;
// import com.ijpay.core.kit.WxPayKit;
// import com.ijpay.wxpay.WxPayApi;
// import com.ijpay.wxpay.enums.WxDomainEnum;
// import com.ijpay.wxpay.enums.v3.OtherApiEnum;
// import com.wechat.pay.java.service.payments.model.Transaction;
// import com.wechat.pay.java.service.refund.model.Refund;
// import com.wechat.pay.java.service.refund.model.Status;
// import io.swagger.v3.oas.annotations.tags.Tag;
//
// import liquibase.pro.packaged.S;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.*;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.ByteArrayInputStream;
// import java.math.BigDecimal;
// import java.nio.charset.StandardCharsets;
// import java.security.cert.X509Certificate;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.concurrent.TimeUnit;
//
//
// /**
//  * @author SWUST
//  */
// @Slf4j
// @Tag(name = "支付退款回调")
// @Validated
// @RestController
// @RequestMapping("wechat/call/back")
// @RequiredArgsConstructor
// public class WeChatNotifyController {
//
//     private final RedisUtils redisUtils;
//
//     private final WeChatPayService weChatPayService;
//
//     private final GfRecordPayService gfRecordPayService;
//
//     private final GfRecordRefundService gfRecordRefundService;
//
//     private final WeChatPayProperty weChatPayProperty;
//
//     String serialNo;
//     // public static void main(String[] args) throws Exception {
//     //     String x = DateTimeZoneUtil.dateToTimeZone(System.currentTimeMillis() + 1000 * 60 * 3);
//     //     System.out.println(x);
//     //     String date = DateTimeZoneUtil.timeZoneDateToStr(x);
//     //     System.out.println(date);
//     //     LocalDateTime parse = LocalDateTime.parse(x, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
//     //     System.out.println(parse);
//     //     System.out.println(LocalDateTime.now());
//     // }
//     @RequestMapping("/get")
//     @ResponseBody
//     public String v3Get() {
//         // 获取平台证书列表
//         try {
//             IJPayHttpResponse response = WxPayApi.v3(
//                     RequestMethodEnum.GET,
//                     WxDomainEnum.CHINA.toString(),
//                     OtherApiEnum.GET_CERTIFICATES.toString(),
//                     weChatPayProperty.getMchId(),
//                     getSerialNumber(),
//                     null,
//                     weChatPayProperty.getKeyPath(),
//                     ""
//             );
//
//             String timestamp = response.getHeader("Wechatpay-Timestamp");
//             String nonceStr = response.getHeader("Wechatpay-Nonce");
//             String serialNumber = response.getHeader("Wechatpay-Serial");
//             String signature = response.getHeader("Wechatpay-Signature");
//
//             String body = response.getBody();
//             int status = response.getStatus();
//
//             log.info("serialNumber: {}", serialNumber);
//             log.info("status: {}", status);
//             log.info("body: {}", body);
//             int isOk = 200;
//             if (status == isOk) {
//                 JSONObject jsonObject = JSONUtil.parseObj(body);
//                 JSONArray dataArray = jsonObject.getJSONArray("data");
//                 // 默认认为只有一个平台证书
//                 JSONObject encryptObject = dataArray.getJSONObject(0);
//                 JSONObject encryptCertificate = encryptObject.getJSONObject("encrypt_certificate");
//                 String associatedData = encryptCertificate.getStr("associated_data");
//                 String cipherText = encryptCertificate.getStr("ciphertext");
//                 String nonce = encryptCertificate.getStr("nonce");
//                 String serialNo = encryptObject.getStr("serial_no");
//                 final String platSerialNo = savePlatformCert(associatedData, nonce, cipherText, weChatPayProperty.getPlatformCertPath());
//                 log.info("平台证书序列号: {} serialNo: {}", platSerialNo, serialNo);
//             }
//             // 根据证书序列号查询对应的证书来验证签名结果
//             boolean verifySignature = WxPayKit.verifySignature(response, weChatPayProperty.getPlatformCertPath());
//             System.out.println("verifySignature:" + verifySignature);
//             return body;
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
//
//     private String savePlatformCert(String associatedData, String nonce, String cipherText, String certPath) {
//         try {
//             AesUtil aesUtil = new AesUtil(weChatPayProperty.getApiV3Key().getBytes(StandardCharsets.UTF_8));
//             // 平台证书密文解密
//             // encrypt_certificate 中的  associated_data nonce  ciphertext
//             String publicKey = aesUtil.decryptToString(
//                     associatedData.getBytes(StandardCharsets.UTF_8),
//                     nonce.getBytes(StandardCharsets.UTF_8),
//                     cipherText
//             );
//             // 保存证书
//             FileWriter writer = new FileWriter("D:\\platform_apiclient_cert.pem");
//             writer.write(publicKey);
//             // 获取平台证书序列号
//             X509Certificate certificate = PayKit.getCertificate(new ByteArrayInputStream(publicKey.getBytes()));
//             return certificate.getSerialNumber().toString(16).toUpperCase();
//         } catch (Exception e) {
//             e.printStackTrace();
//             return e.getMessage();
//         }
//     }
//     private String getSerialNumber() {
//         if (StrUtil.isEmpty(serialNo)) {
//             // todo 获取证书序列号
//             X509Certificate certificate = PayKit.getCertificate(weChatPayProperty.getCertPath());
//             if (ObjectUtil.isNotNull(certificate)) {
//                 serialNo = certificate.getSerialNumber().toString(16).toUpperCase();
//                 // 提前两天检查证书是否有效
//                 boolean isValid = PayKit.checkCertificateIsValid(certificate, weChatPayProperty.getMchId(), -2);
//                 log.info("证书是否可用 {} 证书有效期为 {}", isValid, DateUtil.format(certificate.getNotAfter(), DatePattern.NORM_DATETIME_PATTERN));
//             }
//         }
//         return serialNo;
//     }
//
//     /**
//      * 支付通知
//      */
//     @RequestMapping(value = "payNotify")
//     public void payNotify(HttpServletRequest request, HttpServletResponse response) {
//         String key = "wechat:pay";
//         String value = IdUtil.randomUUID();
//         redisUtils.lock(key, value);
//         try {
//             // 支付成功业务处理
//             gfRecordPayService.payNotify(weChatPayService.payNotify(request));
//         } catch (Exception e) {
//             log.error(e.getMessage());
//             // 失败应答
//             response.setStatus(ResponseCodeConstants.FAIL);
//             ResponseUtils.outHttpJson(response, MapUtil.builder().put("code", "FAIL").put("message", e.getMessage()).build());
//         } finally {
//             redisUtils.unLock(key, value);
//         }
//         // 成功应答
//         response.setStatus(ResponseCodeConstants.SUCCESS);
//         ResponseUtils.outHttpJson(response, Result.success());
//     }
//
//     /**
//      * 退款通知
//      */
//     @PostMapping(value = "/refundNotify")
//     public void refundNotify(HttpServletRequest request) {
//         String key = "wechat:refund";
//         String value = IdUtil.randomUUID();
//         redisUtils.lock(key, value);
//         try {
//             // 获取退款回调，更新退款数据状态
//             gfRecordRefundService.refundNotify(weChatPayService.refundNotify(request));
//         } catch (Exception e) {
//             log.error(e.getMessage());
//         } finally {
//             redisUtils.unLock(key, value);
//         }
//     }
//
// }
