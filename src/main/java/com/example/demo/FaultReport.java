package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fault_reports") // Maps this class to the "fault_reports" collection in MongoDB
public class FaultReport {

    @Id
    private String id; // Unique identifier for the fault report
    private String location; // Location of the fault
    private String issueType; // Type of issue (e.g., Transformer Issue, Power Outage)
    private String description; // Additional details about the fault
    private String reportedBy; // Name or identifier of the person reporting the fault
    private long reportedAt; // Timestamp of when the fault was reported (in milliseconds)
    private String status = "Reported"; // Default status of the fault report

    // Default constructor (required by Spring Data)
    public FaultReport() {}

    // Constructor with all fields (optional, for convenience)
    public FaultReport(String location, String issueType, String description, String reportedBy, long reportedAt, String status) {
        this.location = location;
        this.issueType = issueType;
        this.description = description;
        this.reportedBy = reportedBy;
        this.reportedAt = reportedAt;
        this.status = status;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public long getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(long reportedAt) {
        this.reportedAt = reportedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}