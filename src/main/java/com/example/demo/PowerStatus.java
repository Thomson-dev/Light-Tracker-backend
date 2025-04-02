package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "power_status")
public class PowerStatus {
    @Id
    private String id;
    private String districtName;
    private String status; // Online, Partial, Outage, Maintenance
    private int subscribersAffected;
    private LocalDateTime lastUpdated;
    private List<StatusUpdate> updateHistory = new ArrayList<>(); // Initialize here

    public PowerStatus() {}

    public PowerStatus(String districtName, String status, int subscribersAffected) {
        this.districtName = districtName;
        this.status = status;
        this.subscribersAffected = subscribersAffected;
        this.lastUpdated = LocalDateTime.now();
        this.updateHistory = new ArrayList<>(); // Ensure initialization in the constructor
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSubscribersAffected() {
        return subscribersAffected;
    }

    public void setSubscribersAffected(int subscribersAffected) {
        this.subscribersAffected = subscribersAffected;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<StatusUpdate> getUpdateHistory() {
        return updateHistory;
    }

    public void setUpdateHistory(List<StatusUpdate> updateHistory) {
        this.updateHistory = updateHistory;
    }
}