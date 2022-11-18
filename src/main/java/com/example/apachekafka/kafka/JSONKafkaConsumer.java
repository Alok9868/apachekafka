package com.example.apachekafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import com.example.apachekafka.kafka.payload.User;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaConsumer {

    private static final Logger logger= LoggerFactory.getLogger(JSONKafkaConsumer.class);

    @KafkaListener(topics = "javaguides_json",groupId = "myGroup")
    public void consume(User data)
    {
        logger.info(String.format("Message recieved in json format-> %s",data.toString()));
    }
}
