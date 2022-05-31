package com.example.publisher.rest;

import javax.ws.rs.QueryParam;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.publisher.core.Response;

public interface PublishMessageRest {

	@GetMapping(path = "/publishString")
	Response<String> publishKafkaMessage(@QueryParam(value = "message") String message);

}
