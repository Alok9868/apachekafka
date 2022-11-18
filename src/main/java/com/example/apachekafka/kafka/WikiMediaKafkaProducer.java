package com.example.apachekafka.kafka;

import com.example.apachekafka.handler.WikimediaChangesHandler;
import com.example.apachekafka.kafka.payload.User;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiMediaKafkaProducer {
    private static final Logger logger= LoggerFactory.getLogger(JSONKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public WikiMediaKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


//    public void sendMessage() throws InterruptedException {
//        String topic="wikimedia_recentchanges";
//
//        EventHandler eventHandler=new WikimediaChangesHandler(kafkaTemplate,topic);
//        String url="https://stream.wikimedia.org/v2/stream/recentchange";
//        EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
//        EventSource eventSource=builder.build();
//        eventSource.start();
//
//        TimeUnit.MINUTES.sleep(10);
//    }

}
