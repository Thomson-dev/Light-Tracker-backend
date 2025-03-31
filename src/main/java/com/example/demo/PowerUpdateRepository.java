package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerUpdateRepository extends MongoRepository<PowerUpdate, String> {
    List<PowerUpdate> findByAreaIgnoreCase(String area);
}
