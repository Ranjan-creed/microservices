package com.example.publisher.core;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Response <T> {

	private HttpStatus status;

	private Integer statusCode;

	private String code;
	
	private String message;
	
	private T responseObj;

}
