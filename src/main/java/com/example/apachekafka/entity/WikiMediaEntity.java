package com.example.apachekafka.entity;

import javax.persistence.*;

@Entity
@Table(name = "wikimedia_recentchange")
public class WikiMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Lob
    private String wikiMediaData;

    public String getWikiMediaData() {
        return wikiMediaData;
    }

    public void setWikiMediaData(String wikiMediaData) {
        this.wikiMediaData = wikiMediaData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
