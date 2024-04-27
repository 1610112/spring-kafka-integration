package com.example.springbootkafka.Controller;

import com.example.springbootkafka.Kafka.JsonKafkaProducer;
import com.example.springbootkafka.PayLoad.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    JsonKafkaProducer jsonKafkaProducer;
    JsonMessageController(JsonKafkaProducer jsonKafkaProducer)
    {
        this.jsonKafkaProducer=jsonKafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user)
    {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message is sent");
    }
}
