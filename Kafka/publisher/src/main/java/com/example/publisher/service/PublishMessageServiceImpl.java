package com.example.publisher.service;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.publisher.core.KafkaMessage;
import com.example.publisher.core.Response;
import com.example.publisher.core.ResponseFactory;
import com.example.coredemo.core.PublishMessage;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class PublishMessageServiceImpl implements PublishMessageService {

	private final String KAFKA_TOPIC = "demo-event";

	KafkaTemplate<String, KafkaMessage> kafkaTemplate;

	@Override
	public Response<String> publishKafkaMessage(String message) {
		log.info("Publishing message {}", message);
		KafkaMessage kafkaMessage = KafkaMessage.builder().message(message).build();
		kafkaTemplate.send(KAFKA_TOPIC, kafkaMessage);
		return ResponseFactory.mapSuccessResponse();
	}

}
