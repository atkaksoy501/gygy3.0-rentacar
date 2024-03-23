package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Maintenance;

public interface MaintenanceService {
    Maintenance add(Maintenance maintenance);
    Maintenance getById(int id);
}
