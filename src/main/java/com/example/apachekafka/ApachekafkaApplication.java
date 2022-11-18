package com.example.apachekafka;

import com.example.apachekafka.handler.WikimediaChangesHandler;
import com.example.apachekafka.kafka.KafkaProducer;
import com.example.apachekafka.kafka.WikiMediaKafkaElasticSearchProducer;
import com.example.apachekafka.kafka.WikiMediaKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApachekafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApachekafkaApplication.class, args);
	}
	@Autowired
	private WikiMediaKafkaProducer wikiMediaKafkaProducer;
	@Autowired
	private WikiMediaKafkaElasticSearchProducer wikiMediaKafkaElasticSearchProducer;

	public void run(String... args) throws Exception {
		wikiMediaKafkaElasticSearchProducer.sendMessage();
	}

}
