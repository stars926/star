//package com.star.commons.ResponseEntity;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import org.springframework.http.HttpStatus;
//
//import java.io.Serial;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 返回数据
// *
// * @author star926
// */
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class ResponseEntity extends HashMap<String, Object> {
//	@Serial
//	private static final long serialVersionUID = 1L;
//
//	public ResponseEntity() {
//		put("code", 0);
//		put("msg", "success");
//	}
//
//	public ResponseEntity(int code, String msg) {
//		put("code", code);
//		put("msg", msg);
//	}
//
//	public static ResponseEntity error() {
//		return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
//	}
//
//	public static ResponseEntity error(String msg) {
//		return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
//	}
//
//	public static ResponseEntity error(int code, String msg) {
//		ResponseEntity r = new ResponseEntity();
//		r.put("code", code);
//		r.put("msg", msg);
//		return r;
//	}
//
//	public static ResponseEntity ok(String msg) {
//		ResponseEntity r = new ResponseEntity();
//		r.put("msg", msg);
//		return r;
//	}
//
//	public static ResponseEntity ok(Map<String, Object> map) {
//		ResponseEntity r = new ResponseEntity();
//		r.putAll(map);
//		return r;
//	}
//
//	public static ResponseEntity ok() {
//		return new ResponseEntity();
//	}
//
//	@Override
//	public ResponseEntity put(String key, Object value) {
//		super.put(key, value);
//		return this;
//	}
//}
