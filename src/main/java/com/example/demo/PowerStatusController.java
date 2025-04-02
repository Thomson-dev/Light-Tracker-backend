package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/power-status")
public class PowerStatusController {
    @Autowired
    private PowerStatusService powerStatusService;

    @GetMapping
    public List<PowerStatus> getAllStatuses() {
        return powerStatusService.getAllPowerStatuses();
    }
    
    
    @PostMapping
    public ResponseEntity<PowerStatus> addPowerStatus(@RequestBody PowerStatus powerStatus) {
        PowerStatus newStatus = powerStatusService.addPowerStatus(powerStatus);
        return ResponseEntity.ok(newStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PowerStatus> updatePowerStatus(@PathVariable String id, @RequestBody PowerStatus powerStatus) {
        PowerStatus updatedStatus = powerStatusService.updatePowerStatus(id, powerStatus.getStatus());
        return ResponseEntity.ok(updatedStatus);
    }
}
