package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/power")
public class PowerUpdateController {

    @Autowired
    private PowerUpdateRepository powerUpdateRepository;

    // ✅ Fetch power updates by area
    @GetMapping("/{area}")
    public ResponseEntity<List<PowerUpdate>> getPowerUpdates(@PathVariable String area) {
        List<PowerUpdate> updates = powerUpdateRepository.findByAreaIgnoreCase(area);
        if (updates.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updates);
        }
        return ResponseEntity.ok(updates);
    }

    // Add a new power update
    @PostMapping("/add")
    public ResponseEntity<String> addPowerUpdate(@RequestBody PowerUpdate powerUpdate) {
        powerUpdate.setLastUpdated(LocalDateTime.now());
        powerUpdateRepository.save(powerUpdate);
        return ResponseEntity.ok("Power update added successfully for " + powerUpdate.getArea());
    }
}