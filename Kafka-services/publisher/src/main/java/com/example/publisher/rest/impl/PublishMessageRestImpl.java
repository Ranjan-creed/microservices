package com.example.publisher.rest.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.publisher.core.Response;
import com.example.publisher.rest.PublishMessageRest;
import com.example.publisher.service.PublishMessageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class PublishMessageRestImpl implements PublishMessageRest {

	private PublishMessageService publishMessageService;

	@Override
	public Response<String> publishKafkaMessage(String message) {
		return publishMessageService.publishKafkaMessage(message);
	}

}
