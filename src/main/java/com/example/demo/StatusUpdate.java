package com.example.demo;

import java.time.LocalDateTime;

public class StatusUpdate {
    private String previousStatus;
    private String newStatus;
    private LocalDateTime updatedAt;

    public StatusUpdate() {}

    public StatusUpdate(String previousStatus, String newStatus) {
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}