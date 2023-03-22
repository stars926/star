//package com.star.web.admin;
//
//
//import com.star.web.admin.pojo.to.WeChatInfoRepsoTo;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//
///**
// * 登录接口
// *
// * @author star926
// */
//@RestController
//public class WeChatLoginController {
//
//	public String restTemplate1(@Valid @NotBlank String code) {
//		String url = "https://open.weixin.qq.com/connect/qrconnect?" +
//				"appid=wx268fcfe924dcb171&" +
//				"redirect_uri=https%3A%2F%2Fwww.zhihu.com%2Foauth%2Fcallback%2Fwechat%3Faction%3Dlogin%26from%3D&" +
//				"response_type=code&" +
//				"scope=snsapi_login#wechat";
//
//		String url2 = "https://api.weixin.qq.com/sns/jscode2session?appid=wx00feb61e6d703fa8"
//				+"&secret=85d6a0b0ae69ea7098e1b50ec3eb3777"
//				+"&code=" + code
//				+"&grant_type=authorization_code";
////		{
////			"access_token":"ACCESS_TOKEN",
////				"expires_in":7200,
////				"refresh_token":"REFRESH_TOKEN","openid":"OPENID",
////				"scope":"SCOPE"
////		}
////https://open.weixin.qq.com/connect/qrconnect
//// ?appid=wx268fcfe924dcb171
//// &redirect_uri=https%3A%2F%2Fwww.zhihu.com%2Foauth%2Fcallback%2Fwechat%3Faction%3Dlogin%26from%3D
//// &response_type=code
//// &scope=snsapi_login#wechat
//		RestTemplate restTemplate = new RestTemplate();
//
//		ResponseEntity<WeChatInfoRepsoTo> forEntity =
//				restTemplate.getForEntity(url, WeChatInfoRepsoTo.class, new HashMap<>());
//		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http:", String.class);
//		String body = responseEntity.getBody();
////		HttpStatus statusCode = responseEntity.getStatusCode();
//		int statusCodeValue = responseEntity.getStatusCodeValue();
//		HttpHeaders headers = responseEntity.getHeaders();
//		StringBuffer result = new StringBuffer();
////		result.append("responseEntity.getBody()：").append(body).append("<hr>")
////				.append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
////				.append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
////				.append("responseEntity.getHeaders()：").append(headers).append("<hr>");
//		return result.toString();
//	}
//
//}
