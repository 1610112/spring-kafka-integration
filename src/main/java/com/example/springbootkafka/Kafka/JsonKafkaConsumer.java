package com.example.springbootkafka.Kafka;

import com.example.springbootkafka.PayLoad.User;
import org.apache.kafka.common.internals.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger logger= LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics="notification_json",groupId = "myGroup")
    public void jsonConsumer(User user)
    {
        logger.info(String.format("Event received by consumer->%s",user.toString()));
    }
}
