package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.GotMaintenanceResponse;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Maintenance;

public interface MaintenanceService {
    CreatedMaintenanceResponse sentToMaintenance(CreateMaintenanceRequest createMaintenanceRequest);
    GotMaintenanceResponse getById(int id);
}
