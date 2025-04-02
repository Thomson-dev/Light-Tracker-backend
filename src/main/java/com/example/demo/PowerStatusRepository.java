package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PowerStatusRepository extends MongoRepository<PowerStatus, String> {
    List<PowerStatus> findAllByOrderByLastUpdatedDesc();
}

