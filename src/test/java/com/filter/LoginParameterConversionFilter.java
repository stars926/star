package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 登录接口请求参数转换
 * 默认请求类型为x-form-urlencoded
 *
 * @author zt
 * @date 2022/9/21 23:38
 */
@Slf4j
@Component
public class LoginParameterConversionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if ("/login".equals(request.getServletPath())) {
			filterChain.doFilter(new LoginParameterConversionFilter.LoginParameterRequestWrapper(request), response);
		} else {
			filterChain.doFilter(request, response);
		}
	}

	protected String d(HttpServletRequest request) throws IOException {
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
		StringBuilder responseStrBuilder = new StringBuilder();
		String inputStr;
		while ((inputStr = streamReader.readLine()) != null) {
			responseStrBuilder.append(inputStr);
		}
		streamReader.close();
		return responseStrBuilder.toString();
	}

	private static class LoginParameterRequestWrapper extends HttpServletRequestWrapper {
		//		private MultiValueMap<String, String> loginParams;
		private String json;
		public LoginParameterRequestWrapper(HttpServletRequest request) throws IOException {
			super(request);

		}

//		/**
//		 * 重载构造方法
//		 *
//		 * @param request http请求
//		 * @param params  存入参数
//		 */
//		public LoginParameterRequestWrapper(HttpServletRequest request, MultiValueMap<String, String> params) {
//			super(request);
//			if (!this.shouldParse(request)) {
//				return null;
//			} else {
//				HttpInputMessage inputMessage = new ServletServerHttpRequest(request) {
//					public InputStream getBody() throws IOException {
//						return request.getInputStream();
//					}
//				};
//				return this.formConverter.read((Class)null, inputMessage);
//			}
////			//将参数表，赋予给当前的Map以便于持有request中的参数
////			this.params.putAll(request.getParameterMap());
////			//这里将扩展参数写入参数表
////			addAllParameters(extendParams);
//			this.loginParams = params;
//		}
//
//		/**
//		 * 必须重写此方法，否则对象中参数值映射不上
//		 *
//		 * @return 所有的参数名
//		 */
//		@Override
//		public Enumeration<String> getParameterNames() {
//			Set<String> names = new LinkedHashSet();
//			names.addAll(Collections.list(super.getParameterNames()));
//			names.addAll(this.loginParams.keySet());
//			return Collections.enumeration(names);
//		}
//
//		/**
//		 * 重写getParameter方法
//		 *
//		 * @param name 参数名
//		 * @return 返回参数值
//		 */
//		@Override
//		public String getParameter(String name) {
//			String queryStringValue = super.getParameter(name);
//			String formValue = this.loginParams.getFirst(name);
//			return queryStringValue != null ? queryStringValue : formValue;
//		}
//
//		@Override
//		public String[] getParameterValues(String name) {
//			String[] parameterValues = super.getParameterValues(name);
//			List<String> formParam = (List)this.formParams.get(name);
//			if (formParam == null) {
//				return parameterValues;
//			} else if (parameterValues != null && this.getQueryString() != null) {
//				List<String> result = new ArrayList(parameterValues.length + formParam.size());
//				result.addAll(Arrays.asList(parameterValues));
//				result.addAll(formParam);
//				return StringUtils.toStringArray(result);
//			} else {
//				return StringUtils.toStringArray(formParam);
//			}
//		}
	}
}
