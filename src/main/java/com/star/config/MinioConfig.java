//package com.star.config;
//
//import com.star.properties.MinioProperties;
//import io.minio.MinioClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author zt
// * @date 2022/6/28 11:19
// */
//@Configuration
//@EnableConfigurationProperties({MinioProperties.class})
//public class MinioConfiguration {
//
//	private MinioProperties minioProperties;
//
//	@Bean
//	public MinioClient minioClient() {
//		return MinioClient
//				.builder()
//				.endpoint(minioProperties.getEndpoint())
//				.credentials(minioProperties.getAccesskey(), minioProperties.getSecretKey())
//				.build();
//	}
//}
