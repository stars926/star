package com;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 *
 * @author star926
 */
public class JwtUtil {

	//private final TokenProperties tokenProperties;

	/**
	 * 有效期为 6 * 60 * 60 * 1000 六个小时
	 */
	public static final Long JWT_TTL = 6 * 60 * 60 * 1000L;

	/**
	 * 设置秘钥明文
	 */
	public static final String JWT_KEY = "devsaykeygenerationneedstobeofsufficientsizedevsaykeygenerationneedstobeofsufficientsize";

	/**
	 * 解析
	 *
	 * @param token token
	 * @return 携带的数据
	 * @throws ParseException 解析失败
	 */
	public static String parseJwt(String token) throws ParseException {
		// 解析 JWS 并验证它
		JWSObject parse = JWSObject.parse(token);
		return parse.getPayload().toString();
	}

	/**
	 * 生成token，永远不过期
	 *
	 * @param subject token中要存放的数据
	 * @return token
	 * @throws JOSEException 长度认证失败，签名认证失败
	 */
	public static String createJwt(String subject) throws JOSEException {
		// 创建 HMAC 签名者
		JWSSigner signer = new MACSigner(JWT_KEY);
		// 准备载荷
		JWSObject jwsObject = new JWSObject(new JWSHeader
				// HS256加密
				.Builder(JWSAlgorithm.HS512)
				// 生产类型 JWT
				.type(JOSEObjectType.JWT)
				.build(), new Payload(subject));
		// 签名
		jwsObject.sign(signer);
		// 序列化
		return jwsObject.serialize();
	}

	public static void main(String[] args) throws JOSEException, ParseException, NoSuchAlgorithmException {
		String jwt = createExpJwt("1");
		System.out.println(jwt);
		System.out.println(parseJwt(jwt));
	}

	/**
	 * 生成token
	 *
	 * @param subject token中要存放的数据
	 * @return token
	 * @throws JOSEException 长度认证失败，签名认证失败
	 */
	public static String createExpJwt(String subject) throws JOSEException, NoSuchAlgorithmException {
		// 当前时间
		Date now = new Date();
		// 过期时间
		Date exp = new Date(now.getTime() + JWT_TTL);
		JWSHeader build = new JWSHeader
				// HS256加密
				.Builder(JWSAlgorithm.RS512)
				// 生产类型 JWT
				.type(JOSEObjectType.JOSE_JSON)
				.build();
		JWTClaimsSet star = new JWTClaimsSet
				.Builder()
				// 唯一的ID
				.jwtID(UUID.randomUUID().toString().replaceAll("-", ""))
				// 设置主题
				.subject(subject)
				// 过期时间，不设置则永不过期
				.expirationTime(exp)
				// 签发者
				.issuer("star")
				// 签发时间
				.issueTime(now).build();

		// HMAC加密解密签名
		//jwsObject.sign(new MACSigner(JWT_KEY));
		// (1) 生成RSA公钥-秘钥对
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PublicKey aPublic = keyPair.getPublic();
		RSASSASigner rsassaSigner = new RSASSASigner(keyPair.getPrivate());
		// 准备载荷
		SignedJWT jwsObject = new SignedJWT(build,star);
		jwsObject.sign(rsassaSigner);
		// 序列化
		return jwsObject.serialize();
	}
}