package com.example.publisher.service;

import com.example.publisher.core.Response;

public interface PublishMessageService {
	
	public Response<String> publishKafkaMessage(String message);

}
