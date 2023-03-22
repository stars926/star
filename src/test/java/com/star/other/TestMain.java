package com.star.other;

import com.star.web.test.DateUtils;
import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

/**
 * @author star926
 * @date 2022/6/13 16:51
 */
public class TestMain {
	public static Logger log = LoggerFactory.getLogger("ss");

	public static void main(String[] args) {
//		byte[] bytes = Base64Utils.decodeFromString("");
//		bcrypt();
		// $2a$10$RM9RXPitTE8.22tewr.WQedlmu3meiuCluemQf8VorfpggJojCnt6

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		String encode = bCryptPasswordEncoder.encode("1234567");
		System.out.println(encode);
		boolean matches1 = bCryptPasswordEncoder.matches("123456","$2a$10$RM9RXPitTE8.22tewr.WQedlmu3meiuCluemQf8VorfpggJojCnt6");
		boolean matches2 = bCryptPasswordEncoder.matches("1234567","$2a$10$RM9RXPitTE8.22tewr.WQedlmu3meiuCluemQf8VorfpggJojCnt6");
		System.out.println(matches1);
		System.out.println(matches2);
	}

	private static void bcrypt() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		String encode = bCryptPasswordEncoder.encode("123456");
		System.out.println(encode);
		boolean matches = bCryptPasswordEncoder.matches("123456",encode);
		System.out.println(matches);

		log.debug("格式化{}",DateUtil.formatAsDatetime(new Date()));
		log.debug("明天{}",DateUtil.formatAsDatetime(DateUtil.tomorrow()));
		log.debug("当前后0天{}", DateUtil.formatAsDatetime(DateUtils.getDateAfter(new Date(),0)));

		log.debug("当前后7天{}", DateUtil.formatAsDatetime(DateUtils.getDateAfter(new Date(),7)));
	}
}
