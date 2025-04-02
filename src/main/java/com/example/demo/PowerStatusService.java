package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PowerStatusService {
    @Autowired
    private PowerStatusRepository powerStatusRepository;

    public List<PowerStatus> getAllPowerStatuses() {
        return powerStatusRepository.findAllByOrderByLastUpdatedDesc();
    }

    
    public PowerStatus addPowerStatus(PowerStatus powerStatus) {
        powerStatus.setLastUpdated(LocalDateTime.now());
        return powerStatusRepository.save(powerStatus);
    }
    
    public PowerStatus updatePowerStatus(String id, String newStatus) {
        Optional<PowerStatus> optionalStatus = powerStatusRepository.findById(id);
        if (!optionalStatus.isPresent()) {
            throw new RuntimeException("District not found");
        }

        PowerStatus powerStatus = optionalStatus.get();
        String oldStatus = powerStatus.getStatus();

        // Update the current status
        powerStatus.setStatus(newStatus);
        powerStatus.setLastUpdated(LocalDateTime.now());

        // Add history entry
        StatusUpdate update = new StatusUpdate(oldStatus, newStatus);
        powerStatus.getUpdateHistory().add(update);

        return powerStatusRepository.save(powerStatus);
    }
}
