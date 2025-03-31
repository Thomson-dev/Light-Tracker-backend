package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report-fault")
public class FaultReportController {

    @Autowired
    private FaultReportRepository faultReportRepository;
    
    // Endpoint to fetch all fault reports
    @GetMapping
    public List<FaultReport> getAllReports() {
        return faultReportRepository.findAll(); // Fetch all reports from MongoDB
    }

    @PostMapping
    public String reportFault(@RequestBody FaultReport faultReport) {
        // Set the reported timestamp
        faultReport.setReportedAt(System.currentTimeMillis());

        // Ensure the status is set to a default value if not provided
        if (faultReport.getStatus() == null || faultReport.getStatus().isEmpty()) {
            faultReport.setStatus("Reported");
        }

        // Save the fault report to the database
        faultReportRepository.save(faultReport);

        return "Fault reported successfully with status: " + faultReport.getStatus();
    }
    
    
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody Map<String, String> requestBody) {
        String status = requestBody.get("status");

        // Define allowed statuses
        List<String> allowedStatuses = Arrays.asList("Pending", "In Progress", "Resolved");

        if (status == null || !allowedStatuses.contains(status)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid status! Allowed values: Pending, In Progress, Resolved.");
        }

        Optional<FaultReport> reportOpt = faultReportRepository.findById(id);

        if (reportOpt.isPresent()) {
            FaultReport report = reportOpt.get();
            report.setStatus(status);
            faultReportRepository.save(report);
            return ResponseEntity.ok(report);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Report not found!");
        }
    }
}





