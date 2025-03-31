package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FaultReportRepository extends MongoRepository<FaultReport, String> {}
