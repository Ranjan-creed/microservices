package com.example.publisher.core;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder(toBuilder = true)
public class KafkaMessage{

	private String message;
}
