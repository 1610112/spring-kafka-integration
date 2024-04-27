package com.example.springbootkafka.Kafka;

import com.example.springbootkafka.PayLoad.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;
    JsonKafkaProducer(KafkaTemplate kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }
    public void sendMessage(User user)
    {
        logger.info(String.format("Event added->%s",user.toString()));
        Message<User> message=MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"notification_json")
                .build();
        kafkaTemplate.send(message);
    }
}
