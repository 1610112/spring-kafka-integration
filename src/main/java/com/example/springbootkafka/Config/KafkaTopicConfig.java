package com.example.springbootkafka.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("notification")
                .partitions(5)
                .build();
    }
    @Bean
    public NewTopic topicNotification(){
        return TopicBuilder.name("notification_json")
                .partitions(5)
                .build();
    }
}
