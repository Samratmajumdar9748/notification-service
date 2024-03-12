package com.samrat.notificationService;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);

	}

	@KafkaListener(topics = "booking-events", groupId = "sweethome", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void listen(@Payload ConsumerRecord<String,String> data) throws IOException {

		System.out.println("Notification received :: "+ data.value());

		log.info("Key :: "+ data.key()+"\nValue :: "+data.value());

	}

}
