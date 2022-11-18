package com.example.apachekafka.kafka;

import com.example.apachekafka.entity.WikiMediaEntity;
import com.example.apachekafka.entity.WikiMediaMongoEntity;
import com.example.apachekafka.repo.WikiMediaElasticSearchRepo;
import com.example.apachekafka.repo.WikiMediaMongoRepo;
import com.example.apachekafka.repo.WikiMediaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaKafkaConsumer {

    @Autowired
    private WikiMediaRepo wikiMediaRepo;
    @Autowired
    private WikiMediaMongoRepo wikiMediaMongoRepo;
    @Autowired
    private WikiMediaElasticSearchRepo wikiMediaElasticSearchRepo;




    private static final Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "wikimedia_recentchanges",groupId = "myGroup")
    public void consume(String message)
    {
//        logger.info(String.format("Message recieved-> %s",message));
        WikiMediaMongoEntity wikiMediaMongoEntity=new WikiMediaMongoEntity();
        wikiMediaMongoEntity.setWikimediaData(message);
        logger.info(String.format("Message recieved and saved in mongodb-> %s", wikiMediaMongoRepo.save(wikiMediaMongoEntity)));
    }


}
