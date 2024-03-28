package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.GetMaintenanceResponseById;

public interface MaintenanceService {
    CreatedMaintenanceResponse sentToMaintenance(CreateMaintenanceRequest createMaintenanceRequest);
    GetMaintenanceResponseById getById(int id);
}
