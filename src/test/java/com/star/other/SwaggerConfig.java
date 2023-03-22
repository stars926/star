package com.star.other;//package com.star.config;
//
////import com.star.properties.SwaggerProperties;
//import com.star.properties.SwaggerProperties;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
//import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
//
//import java.lang.reflect.Field;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Swagger配置
// *
// * @author star926
// */
//@EnableOpenApi
//@Configuration
//@RequiredArgsConstructor
//public class SwaggerConfig implements WebMvcConfigurer{
//
//	private final SwaggerProperties swaggerProperties;
//
//	/**
//	 * swagger3
//	 *
//	 * @return
//	 */
//	@Bean
//	public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//		return new BeanPostProcessor() {
//			@Override
//			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//				if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
//					customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
//				}
//				return bean;
//			}
//
//			private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
//				List<T> copy = mappings.stream()
//						.filter(mapping -> mapping.getPatternParser() == null)
//						.collect(Collectors.toList());
//				mappings.clear();
//				mappings.addAll(copy);
//			}
//
//			@SuppressWarnings("unchecked")
//			private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
//				try {
//					Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
//					field.setAccessible(true);
//					return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					throw new IllegalStateException(e);
//				}
//			}
//		};
//	}
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//				.pathMapping("/")
//                // 定义是否开启swagger，false为关闭，可以通过变量控制
//                .enable(swaggerProperties.getEnable())
//                // 将api的元信息设置为包含在json ResourceListing响应中。
//                .apiInfo(apiInfo())
//                // 接口调试地址
//                .host(swaggerProperties.getHost())
//                // 选择哪些接口作为swagger的doc发布
//                .select()
//				// 过滤条件，扫描指定路径下的文件
//				.apis(RequestHandlerSelectors.basePackage("com.star.web.*.controller"))
//				.paths(PathSelectors.any())
//                .build()
//                // 支持的通讯协议集合
//                .protocols(swaggerProperties.getProtocols());
//                // 授权信息设置，必要的header token等认证信息
////                .securitySchemes(securitySchemes())
////                // 授权信息全局应用
////                .securityContexts(securityContexts());
//    }
//
//    /**
//     * API 页面上半部分展示信息
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(swaggerProperties.getName() + " Api Doc")
//                .description(swaggerProperties.getDescription())
//                .contact(new Contact("star926", "www.star.com", "575951767@qq.com"))
//                .version("服务版本: " + swaggerProperties.getVersion())
//                .build();
//    }
//
//}