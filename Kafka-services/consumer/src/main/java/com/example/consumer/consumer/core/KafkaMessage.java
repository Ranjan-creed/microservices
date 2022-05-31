package com.example.consumer.consumer.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class KafkaMessage {

	private String message;
}
