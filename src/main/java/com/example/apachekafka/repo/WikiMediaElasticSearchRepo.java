package com.example.apachekafka.repo;


import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.example.apachekafka.entity.WikiMediaElasticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WikiMediaElasticSearchRepo {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private final String indexName = "product";


    public String createOrUpdateDocument(WikiMediaElasticEntity wikiMediaElasticEntity) throws IOException {

        IndexResponse response = elasticsearchClient.index(i -> i
                        .index(indexName)
//                        .id(Product.getId())
                        .document(wikiMediaElasticEntity)
        );
        if (response.result()
                .name()
                .equals("Created")) {
            return wikiMediaElasticEntity.toString();
        } else if (response.result()
                .name()
                .equals("Updated")) {
            return null;
        }
        return null;
    }
    public List<WikiMediaElasticEntity> searchAllDocuments( ) throws IOException {

        SearchRequest searchRequest = SearchRequest.of(s -> s.index(indexName));
        SearchResponse searchResponse = elasticsearchClient.search(searchRequest, WikiMediaElasticEntity.class);
        List<Hit> hits = searchResponse.hits()
                .hits();
        List<WikiMediaElasticEntity> products = new ArrayList<>();
        for (Hit object : hits) {
            System.out.print(object.source());
            products.add((WikiMediaElasticEntity) object.source());
        }
        return products;
    }
}
