package com.example.apachekafka.kafka;

import com.example.apachekafka.entity.WikiMediaElasticEntity;
import com.example.apachekafka.entity.WikiMediaMongoEntity;
import com.example.apachekafka.repo.WikiMediaElasticSearchRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WikiMediaKafkaElasticSearchConsumer {

    @Autowired
    private WikiMediaElasticSearchRepo wikiMediaElasticSearchRepo;

    private static final Logger logger= LoggerFactory.getLogger(WikiMediaKafkaElasticSearchConsumer.class);
    @KafkaListener(topics = "wikimedia_elasticsearch_recentchanges",groupId = "myGroup")
    public void consume(String message) throws IOException {
        WikiMediaElasticEntity wikiMediaElasticEntity=new WikiMediaElasticEntity();
        wikiMediaElasticEntity.setWikimediaData(message);
        try {

            logger.info(String.format("Message recieved and saved in elastic search-> %s",
                    wikiMediaElasticSearchRepo.createOrUpdateDocument(wikiMediaElasticEntity)));
        }
        catch ( Exception e )
        {
            logger.error(e.getMessage());
        }

    }
}
