package com.example.apachekafka.repo;

import com.example.apachekafka.entity.WikiMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaRepo  extends JpaRepository<WikiMediaEntity,Long> {

}
