//package com.star.config;
//
//import org.springframework.http.*;
//import org.springframework.lang.Nullable;
//import org.springframework.util.MultiValueMap;
//
//import java.net.URI;
//import java.time.Instant;
//import java.time.ZonedDateTime;
//import java.util.Arrays;
//import java.util.LinkedHashSet;
//import java.util.function.Consumer;
//
///**
// * @author star926
// * @date 2022/6/20 17:17
// */
//import java.net.URI;
//import java.time.Instant;
//import java.time.ZonedDateTime;
//import java.util.Arrays;
//import java.util.LinkedHashSet;
//import java.util.Optional;
//import java.util.function.Consumer;
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//import org.springframework.util.MultiValueMap;
//import org.springframework.util.ObjectUtils;
//
//public class ResponseEntity<T> extends HttpEntity<T> {
//
//	public ResponseEntity(HttpStatus status) {
//		this((Object)null, (MultiValueMap)null, (HttpStatus)status);
//	}
//
//	public ResponseEntity(@Nullable T body, HttpStatus status) {
//		this(body, (MultiValueMap)null, (HttpStatus)status);
//	}
//
//	public ResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
//		this((Object)null, headers, (HttpStatus)status);
//	}
//
//	public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatus status) {
//		this(body, headers, (Object)status);
//	}
//
//	public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, int rawStatus) {
//		this(body, headers, (Object)rawStatus);
//	}
//
//	private ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, Object status) {
//		super(body, headers);
//		Assert.notNull(status, "HttpStatus must not be null");
//		this.status = status;
//	}
//
//	public HttpStatus getStatusCode() {
//		return this.status instanceof HttpStatus ? (HttpStatus)this.status : HttpStatus.valueOf((Integer)this.status);
//	}
//
//	public int getStatusCodeValue() {
//		return this.status instanceof HttpStatus ? ((HttpStatus)this.status).value() : (Integer)this.status;
//	}
//
//	public boolean equals(@Nullable Object other) {
//		if (this == other) {
//			return true;
//		} else if (!super.equals(other)) {
//			return false;
//		} else {
//			org.springframework.http.ResponseEntity<?> otherEntity = (org.springframework.http.ResponseEntity)other;
//			return ObjectUtils.nullSafeEquals(this.status, otherEntity.status);
//		}
//	}
//
//	public int hashCode() {
//		return 29 * super.hashCode() + ObjectUtils.nullSafeHashCode(this.status);
//	}
//
//	public String toString() {
//		StringBuilder builder = new StringBuilder("<");
//		builder.append(this.status);
//		if (this.status instanceof HttpStatus) {
//			builder.append(' ');
//			builder.append(((HttpStatus)this.status).getReasonPhrase());
//		}
//
//		builder.append(',');
//		T body = this.getBody();
//		HttpHeaders headers = this.getHeaders();
//		if (body != null) {
//			builder.append(body);
//			builder.append(',');
//		}
//
//		builder.append(headers);
//		builder.append('>');
//		return builder.toString();
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder status(HttpStatus status) {
//		Assert.notNull(status, "HttpStatus must not be null");
//		return new org.springframework.http.ResponseEntity.DefaultBuilder(status);
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder status(int status) {
//		return new org.springframework.http.ResponseEntity.DefaultBuilder(status);
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder ok() {
//		return status(HttpStatus.OK);
//	}
//
//	public static <T> org.springframework.http.ResponseEntity<T> ok(@Nullable T body) {
//		return ok().body(body);
//	}
//
//	public static <T> org.springframework.http.ResponseEntity<T> of(Optional<T> body) {
//		Assert.notNull(body, "Body must not be null");
//		return (org.springframework.http.ResponseEntity)body.map(org.springframework.http.ResponseEntity::ok).orElseGet(() -> {
//			return notFound().build();
//		});
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder created(URI location) {
//		return (org.springframework.http.ResponseEntity.BodyBuilder)status(HttpStatus.CREATED).location(location);
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder accepted() {
//		return status(HttpStatus.ACCEPTED);
//	}
//
//	public static org.springframework.http.ResponseEntity.HeadersBuilder<?> noContent() {
//		return status(HttpStatus.NO_CONTENT);
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder badRequest() {
//		return status(HttpStatus.BAD_REQUEST);
//	}
//
//	public static org.springframework.http.ResponseEntity.HeadersBuilder<?> notFound() {
//		return status(HttpStatus.NOT_FOUND);
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder unprocessableEntity() {
//		return status(HttpStatus.UNPROCESSABLE_ENTITY);
//	}
//
//	public static org.springframework.http.ResponseEntity.BodyBuilder internalServerError() {
//		return status(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	private static class DefaultBuilder implements org.springframework.http.ResponseEntity.BodyBuilder {
//		private final Object statusCode;
//		private final HttpHeaders headers = new HttpHeaders();
//
//		public DefaultBuilder(Object statusCode) {
//			this.statusCode = statusCode;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder header(String headerName, String... headerValues) {
//			String[] var3 = headerValues;
//			int var4 = headerValues.length;
//
//			for(int var5 = 0; var5 < var4; ++var5) {
//				String headerValue = var3[var5];
//				this.headers.add(headerName, headerValue);
//			}
//
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder headers(@Nullable HttpHeaders headers) {
//			if (headers != null) {
//				this.headers.putAll(headers);
//			}
//
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder headers(Consumer<HttpHeaders> headersConsumer) {
//			headersConsumer.accept(this.headers);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder allow(HttpMethod... allowedMethods) {
//			this.headers.setAllow(new LinkedHashSet(Arrays.asList(allowedMethods)));
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder contentLength(long contentLength) {
//			this.headers.setContentLength(contentLength);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder contentType(MediaType contentType) {
//			this.headers.setContentType(contentType);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder eTag(String etag) {
//			if (!etag.startsWith("\"") && !etag.startsWith("W/\"")) {
//				etag = "\"" + etag;
//			}
//
//			if (!etag.endsWith("\"")) {
//				etag = etag + "\"";
//			}
//
//			this.headers.setETag(etag);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder lastModified(ZonedDateTime date) {
//			this.headers.setLastModified(date);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder lastModified(Instant date) {
//			this.headers.setLastModified(date);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder lastModified(long date) {
//			this.headers.setLastModified(date);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder location(URI location) {
//			this.headers.setLocation(location);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder cacheControl(CacheControl cacheControl) {
//			this.headers.setCacheControl(cacheControl);
//			return this;
//		}
//
//		public org.springframework.http.ResponseEntity.BodyBuilder varyBy(String... requestHeaders) {
//			this.headers.setVary(Arrays.asList(requestHeaders));
//			return this;
//		}
//
//		public <T> org.springframework.http.ResponseEntity<T> build() {
//			return this.body((Object)null);
//		}
//
//		public <T> org.springframework.http.ResponseEntity<T> body(@Nullable T body) {
//			return new org.springframework.http.ResponseEntity(body, this.headers, this.statusCode);
//		}
//	}
//
//	public interface BodyBuilder extends org.springframework.http.ResponseEntity.HeadersBuilder<org.springframework.http.ResponseEntity.BodyBuilder> {
//		org.springframework.http.ResponseEntity.BodyBuilder contentLength(long contentLength);
//
//		org.springframework.http.ResponseEntity.BodyBuilder contentType(MediaType contentType);
//
//		<T> org.springframework.http.ResponseEntity<T> body(@Nullable T body);
//	}
//
//	public interface HeadersBuilder<B extends org.springframework.http.ResponseEntity.HeadersBuilder<B>> {
//		B header(String headerName, String... headerValues);
//
//		B headers(@Nullable HttpHeaders headers);
//
//		B headers(Consumer<HttpHeaders> headersConsumer);
//
//		B allow(HttpMethod... allowedMethods);
//
//		B eTag(String etag);
//
//		B lastModified(ZonedDateTime lastModified);
//
//		B lastModified(Instant lastModified);
//
//		B lastModified(long lastModified);
//
//		B location(URI location);
//
//		B cacheControl(CacheControl cacheControl);
//
//		B varyBy(String... requestHeaders);
//
//		<T> org.springframework.http.ResponseEntity<T> build();
//	}
//}
//
