package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.MaintenanceMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private MaintenanceRepository maintenanceRepository;

    public void maintenanceMustExists(int maintenanceId) {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(maintenanceId);
        if (maintenance.isEmpty()) {
            throw new BusinessException(MaintenanceMessages.MAINTENANCE_NOT_FOUND);
        }
    }

}
