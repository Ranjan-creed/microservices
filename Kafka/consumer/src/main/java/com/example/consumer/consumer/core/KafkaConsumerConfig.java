package com.example.consumer.consumer.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Value("${bootstarp-service-url}")
	String bootstarapServerUrl;

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstarapServerUrl);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "string_group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory=new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, KafkaMessage> jsonConsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstarapServerUrl);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "json_group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<String,KafkaMessage>(config,new StringDeserializer(),
				new JsonDeserializer<>(KafkaMessage.class,false));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,KafkaMessage> jsonKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> factory=new ConcurrentKafkaListenerContainerFactory<String, KafkaMessage>();
		factory.setConsumerFactory(jsonConsumerFactory());
		return factory;
	}
}
