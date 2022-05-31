package com.example.consumer.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumer.consumer.core.KafkaMessage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ListnerService {

	private final String KAFKA_STRING_TOPIC = "msg-demo";
	private final String KAFKA_JSON_TOPIC = "demo-event";

	@KafkaListener(topics = KAFKA_STRING_TOPIC, groupId = "string_group_id")
	public void consumeMessage(String message) {
		log.info("Consumed Message==== {}", message);
	}

	@KafkaListener(topics = KAFKA_JSON_TOPIC, groupId = "json_group_id", containerFactory = "jsonKafkaListenerContainerFactory")
	public void consumeJsonMessage(KafkaMessage message) {
		log.info("Consumed Message==== {}", message);
	}
}
