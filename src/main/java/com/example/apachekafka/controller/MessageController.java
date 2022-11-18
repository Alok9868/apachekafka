package com.example.apachekafka.controller;

import com.example.apachekafka.entity.WikiMediaElasticEntity;
import com.example.apachekafka.kafka.KafkaProducer;
import com.example.apachekafka.kafka.payload.User;
import com.example.apachekafka.repo.WikiMediaElasticSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private WikiMediaElasticSearchRepo wikiMediaElasticSearchRepo;


    public MessageController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer=kafkaProducer;
    }

    @GetMapping ("/sendmsg")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent successfully");
    }
    @GetMapping("/getelastic")
    public List<WikiMediaElasticEntity> getAllDataInElasticSearch() throws IOException {
        return wikiMediaElasticSearchRepo.searchAllDocuments();
    }



    @GetMapping
    public String live()
    {
        return "live";
    }


}
