package com.example.apachekafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicconfig {

    @Bean
    public NewTopic javaGuideTopic()
    {
        return TopicBuilder.name("javaguides").build();
    }

    @Bean
    public NewTopic javaGuideTopicJSON()
    {
        return TopicBuilder.name("javaguides_json").build();
    }
    @Bean
    public NewTopic WikiMediaTopic()
    {
        return TopicBuilder.name("wikimedia_recentchanges").build();
    }
    @Bean
    public NewTopic WikiMediaElasticSearchTopic()
    {
        return TopicBuilder.name("wikimedia_elasticsearch_recentchanges").build();
    }

}
