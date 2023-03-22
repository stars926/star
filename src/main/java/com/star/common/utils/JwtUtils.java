package com.star.common.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.star.properties.JwtProperties;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 *
 * @author star926
 */
public class JwtUtils {

	private static final JwtProperties JWT_PROPERTIES = SpringUtils.getBean(JwtProperties.class);

	/**
	 * 生成token
	 *
	 * @param subject token中要存放的数据
	 * @return token
	 * @throws JOSEException 长度认证失败，签名认证失败
	 */
	public static String createJwt(String subject) throws JOSEException {
		// 当前时间
		Date now = new Date();
		// 过期时间
		//Date exp = new Date(now.getTime() + JWT_PROPERTIES.getExpirationTimeToMillis());
		Date exp = new Date(now.getTime() + Duration.ofSeconds(1).toMillis());
		// jwt类型：HS256加密，生产类型 JWT
		JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS512).type(JOSEObjectType.JWT).build();
		// jwt属性
		JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
				// 唯一ID
				.jwtID(getJti())
				// 主题
				.subject(subject)
				// 过期时间(秒)，不设置则永不过期
				.expirationTime(exp)
				// 签发者
				.issuer(JWT_PROPERTIES.getIssuer())
				// 签发时间
				.issueTime(now).build();

		// HMAC加密解密签名
		MACSigner macSigner = new MACSigner(JWT_PROPERTIES.getSecret());
		// 准备载荷并签名
		SignedJWT signedJwt = new SignedJWT(jwsHeader, jwtClaimsSet);
		signedJwt.sign(macSigner);
		// 序列化返回
		return signedJwt.serialize();
	}

	/**
	 * 解析token获取主题内容
	 *
	 * @param token token
	 * @return 主题内容
	 * @throws ParseException 解析失败
	 */
	public static String parseJwt(String token) throws ParseException {
		return JWSObject.parse(token).getPayload().toSignedJWT().getJWTClaimsSet().getSubject();
	}

	/**
	 * 校验是否过期
	 *
	 * @param token token
	 * @return 主题内容
	 * @throws ParseException 解析失败
	 */
	public static Boolean isExpiration(String token) throws ParseException {
		Date expirationTime = JWSObject.parse(token).getPayload().toSignedJWT().getJWTClaimsSet().getExpirationTime();
		return expirationTime.before(new Date());
	}

	/**
	 * 校验是否剩余半小时
	 *
	 * @param token token
	 * @return 主题内容
	 * @throws ParseException 解析失败
	 */
	public static Boolean isExpiringSoon(String token) throws ParseException {
		Long tokenSurplusTime = JWSObject.parse(token).getPayload().toSignedJWT().getJWTClaimsSet().getExpirationTime().getTime();
		Long nowTime = System.currentTimeMillis();
		return JWT_PROPERTIES.getRenewalTimeToMillis() < (tokenSurplusTime - nowTime);
	}

	/**
	 * token续期
	 *
	 * @param token token
	 * @return 主题内容
	 * @throws ParseException 解析失败
	 */
	public static String freshJwt(String token) throws ParseException, JOSEException {
		String payload = JWSObject.parse(token).getPayload().toString();
		return createJwt(payload);
	}

	public static String getHeader(){
		return JWT_PROPERTIES.getHeader();
	}

	/**
	 * 获取32UUID
	 *
	 * @return 32UUID
	 */
	@NotNull
	private static String getJti() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}