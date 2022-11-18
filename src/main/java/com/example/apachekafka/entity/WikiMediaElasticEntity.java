package com.example.apachekafka.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(indexName = "product")
public class WikiMediaElasticEntity {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "wikimediadata")
    private String wikimediaData;
}
