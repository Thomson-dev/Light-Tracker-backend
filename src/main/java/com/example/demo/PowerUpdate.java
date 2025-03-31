package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "power_updates")
public class PowerUpdate {

    @Id
    private String id;
    private String area;
    private String status;
    private LocalDateTime lastUpdated;

    // Default constructor
    public PowerUpdate() {}

    // Constructor
    public PowerUpdate(String area, String status, LocalDateTime lastUpdated) {
        this.area = area;
        this.status = status;
        this.lastUpdated = lastUpdated;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}