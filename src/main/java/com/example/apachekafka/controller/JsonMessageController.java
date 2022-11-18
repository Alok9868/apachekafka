package com.example.apachekafka.controller;

import com.example.apachekafka.kafka.JSONKafkaProducer;
import com.example.apachekafka.kafka.KafkaProducer;
import com.example.apachekafka.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JSONKafkaProducer jsonKafkaProducer;

    @PostMapping("/sendjson")
    public ResponseEntity<String> publishJson(@RequestBody User user)
    {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("message send in json format successfully")  ;
    }




}
