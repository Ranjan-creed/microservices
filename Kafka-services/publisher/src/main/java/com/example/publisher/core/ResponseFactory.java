package com.example.publisher.core;

import org.springframework.http.HttpStatus;

public class ResponseFactory {

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapSuccessResponse() {
		return (Response<T>) Response.builder().statusCode(HttpStatus.OK.value()).status(HttpStatus.OK).build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapSuccessResponse(String message) {
		return (Response<T>) Response.builder().statusCode(HttpStatus.OK.value()).message(message).status(HttpStatus.OK)
				.build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapSuccessResponse(String message, String code) {
		return (Response<T>) Response.builder().statusCode(HttpStatus.OK.value()).message(message).code(code)
				.status(HttpStatus.OK).build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapSuccessResponse(String message, String code, T responseObj) {
		return (Response<T>) Response.builder().statusCode(HttpStatus.OK.value()).message(message).code(code)
				.responseObj(responseObj).status(HttpStatus.OK).build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapFailureResponse() {
		return (Response<T>) Response.builder().statusCode(500).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapFailureResponse(HttpStatus httptatus, String message) {
		return (Response<T>) Response.builder().statusCode(httptatus.value()).message(message).status(httptatus)
				.build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapFailureResponse(HttpStatus httptatus, String message, String code) {
		return (Response<T>) Response.builder().statusCode(httptatus.value()).message(message).code(code)
				.status(httptatus).build();
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> mapFailureResponse(HttpStatus httptatus, String message, String code, T responseObj) {
		return (Response<T>) Response.builder().statusCode(httptatus.value()).message(message).code(code)
				.responseObj(responseObj).status(httptatus).build();
	}

}
