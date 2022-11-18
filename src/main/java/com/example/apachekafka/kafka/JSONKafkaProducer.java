package com.example.apachekafka.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.apachekafka.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaProducer {

    private static final Logger logger= LoggerFactory.getLogger(JSONKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,User>kafkaTemplate;

    public JSONKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(User data)
    {
        logger.info(String.format("Message sent -> %s",data.toString()));
        Message<User> message= MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"javaguides_json")
                .build();

        kafkaTemplate.send(message);
    }

}
