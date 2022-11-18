package com.example.apachekafka.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "wikimediaMongoData")
@Getter
@Setter
@NoArgsConstructor
public class WikiMediaMongoEntity {

    @Id
    private String id;
    private String wikimediaData;

}
